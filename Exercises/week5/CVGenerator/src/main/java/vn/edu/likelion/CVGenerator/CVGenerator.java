package vn.edu.likelion.CVGenerator;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class CVGenerator {
    private static final float PAGE_MARGIN = 50;
    private static final float CONTENT_WIDTH = PDRectangle.A4.getWidth() - 2 * PAGE_MARGIN;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter LinkedIn or Website URL: ");
        String link = scanner.nextLine();

        System.out.print("Enter summary: ");
        String summary = scanner.nextLine();

        System.out.println("Enter Skill Highlights (separate each skill with a semicolon ';'): ");
        String skillHighlights = scanner.nextLine();

        System.out.println("Enter Experience (use new line for each line in the experience section, end input with an empty line): ");
        StringBuilder experienceBuilder = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            experienceBuilder.append(line).append("\n");
        }
        String experience = experienceBuilder.toString();

        System.out.print("Enter Education: ");
        String education = scanner.nextLine();

        System.out.println("Enter Certifications (separate each certification with a semicolon ';'): ");
        String certifications = scanner.nextLine();

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            PDImageXObject image = PDImageXObject.createFromFile("photo.jpg", document);
            contentStream.drawImage(image, 450, 650, 100, 100);

            addText(contentStream, name, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 20, PAGE_MARGIN, 750, Color.BLACK);
            addText(contentStream, phoneNumber + "\n" + email + "\n" + link, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12, PAGE_MARGIN, 720, Color.BLACK);

            float yPosition = 670;
            yPosition = addSection(contentStream, "Summary", summary, PAGE_MARGIN, yPosition);
            yPosition = addSection(contentStream, "Skill Highlights", formatSkills(skillHighlights), PAGE_MARGIN, yPosition);
            yPosition = addSection(contentStream, "Experience", experience, PAGE_MARGIN, yPosition);
            yPosition = addSection(contentStream, "Education", education, PAGE_MARGIN, yPosition);
            yPosition = addSection(contentStream, "Certifications", formatSkills(certifications), PAGE_MARGIN, yPosition);

            contentStream.close();
            document.save("CV_" + name.replaceAll(" ", "_") + ".pdf");
            document.close();
            System.out.println("PDF created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addText(PDPageContentStream contentStream, String text, PDType1Font font, int fontSize, float x, float y, Color color) throws IOException {
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(color);

        String[] lines = text.split("\n");
        for (String line : lines) {
            y = addWrappedText(contentStream, line, font, fontSize, x, y);
        }
    }

    private static float addSection(PDPageContentStream contentStream, String title, String content, float x, float y) throws IOException {
        addText(contentStream, title, new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 16, x, y, Color.BLACK);
        return addMultilineText(contentStream, content, new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12, x, y - 20, Color.BLACK);
    }

    private static float addMultilineText(PDPageContentStream contentStream, String text, PDType1Font font, int fontSize, float x, float y, Color color) throws IOException {
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(color);

        String[] lines = text.split("\n");
        for (String line : lines) {
            y = addWrappedText(contentStream, line, font, fontSize, x, y);
        }

        return y;
    }

    private static float addWrappedText(PDPageContentStream contentStream, String text, PDType1Font font, int fontSize, float x, float y) throws IOException {
        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);

        float currentWidth = 0;
        float spaceWidth = font.getStringWidth(" ") / 1000 * fontSize;
        String[] words = text.split(" ");
        for (String word : words) {
            float wordWidth = font.getStringWidth(word) / 1000 * fontSize;
            if (currentWidth + wordWidth > CONTENT_WIDTH) {
                contentStream.endText();
                y -= fontSize + 2;
                contentStream.beginText();
                contentStream.newLineAtOffset(x, y);
                currentWidth = 0;
            }
            contentStream.showText(word + " ");
            currentWidth += wordWidth + spaceWidth;
        }

        contentStream.endText();
        return y - fontSize - 2;
    }

    private static String formatSkills(String skills) {
        String[] skillsArray = skills.split(";");
        StringBuilder formattedSkills = new StringBuilder();
        for (String skill : skillsArray) {
            formattedSkills.append("• ").append(skill.trim()).append("\n");
        }
        return formattedSkills.toString();
    }
}
