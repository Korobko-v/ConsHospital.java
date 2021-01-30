package net.thumbtack.school.file;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.pictures.v3.Point;
import net.thumbtack.school.pictures.v3.RectPicture;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFileService {
    @TempDir
    public Path tempDir;


    @Test
    public void testFileReadWriteByteArray1() throws IOException {
        byte[] arrayToWrite = {0, 1, 5, -34, 67, -123};
        File file = Files.createFile(tempDir.resolve("test.dat")).toFile();
        FileService.writeByteArrayToBinaryFile(file, arrayToWrite);
        assertTrue(file.exists());
        assertEquals(arrayToWrite.length, file.length());
        byte[] arrayRead = FileService.readByteArrayFromBinaryFile(file);
        assertArrayEquals(arrayToWrite, arrayRead);
    }

    @Test
    public void testWriteByteArrayToBinaryFileException() {
        assertThrows(IOException.class, () -> FileService.writeByteArrayToBinaryFile("", null));
    }

    @Test
    public void testFileReadWriteByteArray2() throws IOException {
        byte[] arrayToWrite = {0, 1, 5, -34, 67, -123};
        String fileName = Files.createFile(tempDir.resolve("test.dat")).toFile().getAbsolutePath();
        FileService.writeByteArrayToBinaryFile(fileName, arrayToWrite);
        File file = new File(fileName);
        assertTrue(file.exists());
        assertEquals(arrayToWrite.length, file.length());
        byte[] arrayRead = FileService.readByteArrayFromBinaryFile(fileName);
        assertArrayEquals(arrayToWrite, arrayRead);
    }

    @Test
    public void testByteStreamReadWriteByteArray() throws IOException {
        byte[] arrayToWrite = {0, 1, 5, -34, 67, -123};
        byte[] result = FileService.writeAndReadByteArrayUsingByteStream(arrayToWrite);
        assertArrayEquals(new byte[]{0, 5, 67}, result);
    }

    @Test
    public void testFileReadWriteByteArray1Buffered() throws IOException {
        byte[] arrayToWrite = {0, 1, 5, -34, 67, -123};
        File file = Files.createFile(tempDir.resolve("test.dat")).toFile();
        FileService.writeByteArrayToBinaryFileBuffered(file, arrayToWrite);
        assertTrue(file.exists());
        assertEquals(arrayToWrite.length, file.length());
        byte[] arrayRead = FileService.readByteArrayFromBinaryFileBuffered(file);
        assertArrayEquals(arrayToWrite, arrayRead);
    }

    @Test
    public void testFileReadWriteByteArray2Buffered() throws IOException {
        byte[] arrayToWrite = {0, 1, 5, -34, 67, -123};
        String fileName = Files.createFile(tempDir.resolve("test.dat")).toFile().getAbsolutePath();
        FileService.writeByteArrayToBinaryFileBuffered(fileName, arrayToWrite);
        File file = new File(fileName);
        assertTrue(file.exists());
        assertEquals(arrayToWrite.length, file.length());
        byte[] arrayRead = FileService.readByteArrayFromBinaryFileBuffered(fileName);
        assertArrayEquals(arrayToWrite, arrayRead);
    }

    @Test
    public void testFileReadWriteRectPictureToBinaryFile() throws GraphicException, IOException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectPicture rectPicture = new RectPicture(topLeft1, bottomRight1, "GIF");
        File file = Files.createFile(tempDir.resolve("test.dat")).toFile();
        FileService.writeRectPictureToBinaryFile(file, rectPicture);
        assertTrue(file.exists());
        assertEquals(21, file.length());
        RectPicture rectPictureRead = FileService.readRectPictureFromBinaryFile(file);
        assertEquals(rectPicture, rectPictureRead);
    }

    @Test
    public void testFileReadRectPictureArrayBinary() throws GraphicException, IOException {
        int count = 5;
        RectPicture[] rectPictures = new RectPicture[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            rectPictures[i] = new RectPicture(new Point(random.nextInt(), random.nextInt()), new Point(random.nextInt(), random.nextInt()),
                    "GIF");
        }
        File file = Files.createFile(tempDir.resolve("test.dat")).toFile();
        FileService.writeRectPictureArrayToBinaryFile(file, rectPictures);
        assertTrue(file.exists());
        assertEquals(count * 16, file.length());
        FileService.modifyRectPictureArrayInBinaryFile(file);
        RectPicture[] rectsRead = FileService.readRectPictureArrayFromBinaryFile(file);
        for (RectPicture rectPicture : rectsRead) {
            rectPicture.moveRel(-1, 0);
        }
        assertArrayEquals(rectPictures, rectsRead);
    }

    @Test
    public void testFileReadWriteRectPictureTextOneLine() throws GraphicException, IOException {
        RectPicture rectPicture = new RectPicture(10000, 10000, 20000, 20000, "GIF");
        File file = Files.createFile(tempDir.resolve("test.txt")).toFile();
        FileService.writeRectPictureToTextFileOneLine(file, rectPicture);
        assertTrue(file.exists());
        assertEquals(1, Files.readAllLines(file.toPath()).size());
        RectPicture rectPictureRead = FileService.readRectPictureFromTextFileOneLine(file);
        assertEquals(rectPicture, rectPictureRead);
    }

    @Test
    public void testFileReadWriteRectPictureTextFiveLines() throws GraphicException, IOException {
        RectPicture rectPicture = new RectPicture(10000, 10000, 20000, 20000, "GIF");
        File file = Files.createFile(tempDir.resolve("test.txt")).toFile();
        FileService.writeRectPictureToTextFileFiveLines(file, rectPicture);
        assertTrue(file.exists());
        assertEquals(5, Files.readAllLines(file.toPath()).size());
        RectPicture rectRead = FileService.readRectPictureFromTextFileFiveLines(file);
        assertEquals(rectPicture, rectRead);
    }

    @Test
    public void testFileReadWriteTraineeTextOneLine() throws NumberFormatException, TrainingException, IOException {
        Trainee traineeToWrite = new Trainee("Ivan", "Ivanov", 2);
        File file = Files.createFile(tempDir.resolve("test.txt")).toFile();
        FileService.writeTraineeToTextFileOneLine(file, traineeToWrite);
        assertTrue(file.exists());
        assertEquals(1, Files.readAllLines(file.toPath()).size());
        Trainee traineeRead = FileService.readTraineeFromTextFileOneLine(file);
        assertEquals(traineeToWrite, traineeRead);
    }

    @Test
    public void testFileReadWriteTraineeTextThreeLines() throws NumberFormatException, TrainingException, IOException {
        Trainee traineeToWrite = new Trainee("Ivan", "Ivanov", 2);
        File file = Files.createFile(tempDir.resolve("test.txt")).toFile();
        FileService.writeTraineeToTextFileThreeLines(file, traineeToWrite);
        assertTrue(file.exists());
        assertEquals(3, Files.readAllLines(file.toPath()).size());
        Trainee traineeRead = FileService.readTraineeFromTextFileThreeLines(file);
        assertEquals(traineeToWrite, traineeRead);
    }

    @Test
    public void testFileSerializeDeserializeTraineeBinary() throws TrainingException, ClassNotFoundException, IOException {
        Trainee traineeToWrite = new Trainee("Иван", "Иванов", 2);
        File file = Files.createFile(tempDir.resolve("test.txt")).toFile();
        FileService.serializeTraineeToBinaryFile(file, traineeToWrite);
        assertTrue(file.exists());
        Trainee traineeRead = FileService.deserializeTraineeFromBinaryFile(file);
        assertEquals(traineeToWrite, traineeRead);
    }

    @Test
    public void testStringSerializeDeserializeTraineeJson() throws TrainingException {
        Trainee traineeToWrite = new Trainee("Иван", "Иванов", 2);
        String json = FileService.serializeTraineeToJsonString(traineeToWrite);
        Trainee traineeRead = FileService.deserializeTraineeFromJsonString(json);
        assertEquals(traineeToWrite, traineeRead);
    }

    @Test
    public void testFileSerializeDeserializeTraineeJson() throws TrainingException, IOException {
        Trainee traineeToWrite = new Trainee("Иван", "Иванов", 2);
        File file = Files.createFile(tempDir.resolve("test.txt")).toFile();
        FileService.serializeTraineeToJsonFile(file, traineeToWrite);
        assertTrue(file.exists());
        Trainee traineeRead = FileService.deserializeTraineeFromJsonFile(file);
        assertEquals(traineeToWrite, traineeRead);
    }

    @Test
    public void testThrowsIOException() {
        Method[] declaredMethods = FileService.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.getName().equals("serializeTraineeToJsonString") || method.getName().equals("deserializeTraineeFromJsonString")) {
                continue;
            }
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            boolean throwIOException = false;
            for (Class<?> exception : exceptionTypes) {
                if (exception == IOException.class) {
                    throwIOException = true;
                    break;
                }
            }
            if (!throwIOException) {
                fail();
            }
        }
    }

}
