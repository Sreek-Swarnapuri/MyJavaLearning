package org.sreek.serialization;

import java.io.*;
import java.lang.reflect.Array;

public class SerializationUtils<T> {

    public void serializeObjects(T[] obs, String fileName) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            for (Object object : obs) {
                System.out.println(object);
                objectOutputStream.writeObject(object);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException in serializeObject - " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Caught IOException in serializeObject - " + e.getMessage());
            e.printStackTrace();
        }

    }

    public T[] deserializeObjects(String fileName, int numberOfObjects, Class<?> clazz) {

        T[] deserializedObjects = null;

        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            deserializedObjects = (T[]) Array.newInstance(clazz, numberOfObjects);

            for (int i = 0; i < numberOfObjects; i++) {
                deserializedObjects[i] = (T) objectInputStream.readObject();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException in deserializeObjects - " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Caught IOException in deserializeObjects - " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Caught ClassNotFoundException in deserializeObjects - " + e.getMessage());
            e.printStackTrace();
        }

        return deserializedObjects;
    }


}
