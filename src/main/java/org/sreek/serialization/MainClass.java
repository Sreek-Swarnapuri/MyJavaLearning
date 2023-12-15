package org.sreek.serialization;

public class MainClass {

    public static void main(String[] args) {

        // If the class declared below is not serialized, it would throw NotSerializableException
        SubSerializedClass subSerializedClass1 = new SubSerializedClass("Test", 234L);
        SerializedClass serializedClass = new SerializedClass("ser1", 1, true, subSerializedClass1);

        SerializationUtils<SerializedClass> serializationUtils = new SerializationUtils<>();

        String serializingFileName = "serialized.ser";

        System.out.println("serializedClass before Serialization - " + serializedClass);
        // Serializing
        serializationUtils.serializeObjects(new SerializedClass[]{serializedClass}, serializingFileName);

        // Deserializing
        SerializedClass[] serializedClasses = serializationUtils.deserializeObjects(serializingFileName, 1, SerializedClass.class);

        System.out.println("serializedClass after Serialization - ");
        for (SerializedClass eachClass : serializedClasses)
            System.out.println(eachClass);


        // Serializing a class which has a parent interface that extends Serializable interface - usage of transient files via serialization
        String childClassSerializingFileName = "ChildClass.ser";
        SerializationUtils<ChildClass> serializationUtilsForChildClass = new SerializationUtils<>();

        ChildClass childClass1 = new ChildClass("ChildClass1", 1.1f, 1);
        ChildClass childClass2 = new ChildClass("ChildClass2", 2.2f, 2);

        ChildClass[] childClasses = new ChildClass[]{childClass1, childClass2};
        System.out.println("ChildClasses before serialization:");
        System.out.println("----------------------------------");
        for (ChildClass cc : childClasses)
            System.out.println(cc);
        System.out.println("----------------------------------");

        serializationUtilsForChildClass.serializeObjects(childClasses, childClassSerializingFileName);

        // We can see from below output that the transient filed will be null as it is not saved in the serialized object
        System.out.println("ChildClasses after serialization:");
        System.out.println("---------------------------------");
        ChildClass[] childClassesAfterSer = serializationUtilsForChildClass.deserializeObjects(childClassSerializingFileName, 2, ChildClass.class);
        for (ChildClass cc : childClassesAfterSer)
            System.out.println(cc);
        System.out.println("----------------------------------");

    }

}
