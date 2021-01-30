package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.pictures.v3.PictureFormat;
import net.thumbtack.school.pictures.v3.Point;
import net.thumbtack.school.pictures.v3.RectPicture;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        for (byte b : array) {
            fos.write(b);
        }
        fos.flush();
        fos.close();
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        for (byte b : array) {
            fos.write(b);
        }
        fos.flush();
        fos.close();
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] array = fis.readAllBytes();
        fis.close();
        return array;
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        return readByteArrayFromBinaryFile(file.getName());
    }

    public static byte[] writeAndReadByteArrayUsingByteStream( byte[] array) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(array);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        byte[] newByte = new byte[bais.available()/2];
        int j = 0;
        for (int i = 0; i < bais.available(); i += 2) {
            newByte[j++] = array[i];
        }
        baos.close();
        bais.close();
        return newByte;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
        bos.write(array);
        bos.close();
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(array);
        bos.close();
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] array = bis.readAllBytes();
        bis.close();
        return array;
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        return readByteArrayFromBinaryFileBuffered(file.getName());
    }

    public static void writeRectPictureToBinaryFile(File file, RectPicture rectPicture) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file, true));
        dos.writeInt(rectPicture.getTopLeft().getX());
        dos.writeInt(rectPicture.getTopLeft().getY());
        dos.writeInt(rectPicture.getBottomRight().getX());
        dos.writeInt(rectPicture.getBottomRight().getY());
        dos.writeUTF(String.valueOf(rectPicture.getFormat()));
        dos.flush();
        dos.close();
    }

    public static RectPicture readRectPictureFromBinaryFile(File file) throws IOException, GraphicException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        RectPicture rectPicture = new RectPicture(new Point(dis.readInt(), dis.readInt()), new Point(dis.readInt(), dis.readInt()), dis.readUTF());
        dis.close();
        return rectPicture;
    }

    public static void writeRectPictureArrayToBinaryFile(File file, RectPicture[] rects ) throws IOException {
        try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < rects.length; i++) {
                stream.writeInt(rects[i].getTopLeft().getX());
                stream.writeInt(rects[i].getTopLeft().getY());
                stream.writeInt(rects[i].getBottomRight().getX());
                stream.writeInt(rects[i].getBottomRight().getY());
            }
        }

        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public static void modifyRectPictureArrayInBinaryFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        for (int i = 0; i < randomAccessFile.length(); i += 8) {
            int x = randomAccessFile.readInt();
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(x+1);
            randomAccessFile.seek(i + 8);
        }
        randomAccessFile.close();
    }

    public static RectPicture[] readRectPictureArrayFromBinaryFile(File file) throws IOException, GraphicException {
        DataInputStream dis = new DataInputStream(new FileInputStream(file.getAbsolutePath()));
        List<RectPicture> list = new ArrayList<>();
        while (dis.available() > 0) {
           list.add(new RectPicture(new Point(dis.readInt(), dis.readInt()), new Point(dis.readInt(), dis.readInt()), "GIF"));
        }
        dis.close();
        RectPicture[] rectPictures = list.toArray(RectPicture[]::new);
        return rectPictures;
    }

    public static void writeRectPictureToTextFileOneLine(File file, RectPicture rectPicture) throws IOException {
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(rectPicture.getTopLeft().getX() + " " + rectPicture.getTopLeft().getY() + " " +
                rectPicture.getBottomRight().getX() + " " + rectPicture.getBottomRight().getY());
        bufferedWriter.close();
        writer.close();
    }

    public static RectPicture readRectPictureFromTextFileOneLine(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String[] parameters = reader.readLine().split(" ");
        reader.close();
        return new RectPicture(new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1])),
                new Point(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3])));
    }

    public static void writeRectPictureToTextFileFiveLines(File file, RectPicture rectPicture) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(rectPicture.getTopLeft().getX() + "\r\n");
        bufferedWriter.write(rectPicture.getTopLeft().getY() + "\r\n");
        bufferedWriter.write(rectPicture.getBottomRight().getX() + "\r\n");
        bufferedWriter.write(rectPicture.getBottomRight().getY() + "\r\n");
        bufferedWriter.write(rectPicture.getFormat().toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public static RectPicture readRectPictureFromTextFileFiveLines(File file) throws IOException, GraphicException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int leftX = Integer.parseInt(bufferedReader.readLine());
        int leftY = Integer.parseInt(bufferedReader.readLine());
        int rightX = Integer.parseInt(bufferedReader.readLine());
        int rightY = Integer.parseInt(bufferedReader.readLine());
        PictureFormat format = PictureFormat.fromString(bufferedReader.readLine());
        bufferedReader.close();
        return new RectPicture(new Point(leftX, leftY), new Point(rightX, rightY), format);
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getRating());
        bufferedWriter.close();
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String[] parameters = bufferedReader.readLine().trim().split(" ");
        bufferedReader.close();
        return new Trainee(parameters[0], parameters[1], Integer.parseInt(parameters[2]));
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        FileWriter fileWriter =

                new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(trainee.getFirstName() + "\r\n");
        bufferedWriter.write(trainee.getLastName() + "\r\n");
        bufferedWriter.write(trainee.getRating() + "\r\n");
        bufferedWriter.close();
        fileWriter.close();
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Trainee trainee = new Trainee(bufferedReader.readLine(), bufferedReader.readLine(),

                Integer.parseInt(bufferedReader.readLine()));
        bufferedReader.close();
        fileReader.close();
        return trainee;
    }
    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(trainee);
        oos.close();
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Trainee trainee = (Trainee) ois.readObject();
        ois.close();
        return trainee;
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson g = new Gson();
        return g.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson g = new Gson();
        return g.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(trainee, bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(file.getAbsolutePath())))) {
            return gson.fromJson(br,Trainee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}