
package com.rajeshkawali.concepts.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * =========================================================
 * JAVA IO + NIO + NIO.2 - IMPORTANT CLASSES
 * =========================================================
 *
 * IO:
 *   InputStream / OutputStream -> binary data
 *   Reader / Writer           -> character data
 *
 * NIO:
 *   Buffer  -> holds data temporarily
 *   Channel -> transfers data
 *
 * NIO.2:
 *   Path  -> represents a file/directory location
 *   Files -> performs file/directory operations
 *
 * This program uses a temporary directory.
 * No existing personal files are overwritten.
 */

public class JavaIONIOExamples {

    public static void main(String[] args) throws Exception {

        Path dir = Files.createTempDirectory("java-io-demo-");

        System.out.println("Demo directory: " + dir);

        // Traditional IO examples
        fileInputOutputStream(dir);
        bufferedByteStreams(dir);
        fileReaderWriter(dir);
        bufferedReaderWriter(dir);
        byteArrayStreams();
        stringReaderWriter();
        dataStreams();
        printWriterExample(dir);
        objectSerialization(dir);
        randomAccessFile(dir);

        // Modern NIO / NIO.2 examples
        pathAndFiles(dir);
        fileChannelAndByteBuffer(dir);
        fileAttributes(dir);
        directoryStreamExample(dir);
        mappedByteBufferExample(dir);

        System.out.println("All examples completed.");
    }

    // =====================================================
    // 1. FileInputStream / FileOutputStream
    // =====================================================

    /*
     * PURPOSE:
     * Read/write raw bytes from/to a file.
     *
     * WHEN:
     * Binary files such as images, PDFs, ZIP files.
     *
     * FileInputStream  -> reads bytes
     * FileOutputStream -> writes bytes
     *
     * Use byte arrays rather than reading one byte
     * at a time for better efficiency.
     */
    static void fileInputOutputStream(Path dir) throws IOException {

        File file = dir.resolve("binary.dat").toFile();
        byte[] data = {10, 20, 30, 40};
        // try-with-resources closes the stream automatically.
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(data);
        }

        try (FileInputStream in = new FileInputStream(file)) {
            byte[] result = in.readAllBytes();
            System.out.println(Arrays.toString(result));
            // [10, 20, 30, 40]
        }
    }

    // =====================================================
    // 2. BufferedInputStream / BufferedOutputStream
    // =====================================================

    /*
     * PURPOSE:
     * Wrap byte streams with buffering.
     *
     * WHEN:
     * Repeated small reads/writes of binary data.
     *
     * Buffered streams reduce frequent calls to
     * the underlying stream.
     *
     * They do NOT convert bytes into characters.
     */
    static void bufferedByteStreams(Path dir) throws IOException {
        Path file = dir.resolve("buffered.bin");
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file.toFile()))) {
            out.write(new byte[]{1, 2, 3, 4, 5});
        }

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file.toFile()))) {
            System.out.println(in.read()); // 1
        }
    }

    // =====================================================
    // 3. FileReader / FileWriter
    // =====================================================

    /*
     * PURPOSE:
     * Read/write character data from/to files.
     *
     * WHEN:
     * Simple text file processing.
     *
     * Here we explicitly specify UTF-8 to avoid
     * depending on the platform default charset.
     *
     * Available in modern Java versions.
     */
    static void fileReaderWriter(Path dir)
            throws IOException {

        File file = dir.resolve("text.txt").toFile();

        try (FileWriter writer =
                     new FileWriter(file, StandardCharsets.UTF_8)) {

            writer.write("Hello Java IO");
        }

        try (FileReader reader =
                     new FileReader(file, StandardCharsets.UTF_8)) {

            char[] chars = new char[100];

            int count = reader.read(chars);

            System.out.println(new String(chars, 0, count));
            // Hello Java IO
        }
    }

    // =====================================================
    // 4. BufferedReader / BufferedWriter
    // =====================================================

    /*
     * PURPOSE:
     * Efficiently read/write text.
     *
     * BufferedReader.readLine()
     * reads one line at a time.
     *
     * WHEN:
     * Logs, CSV files, configuration files,
     * large text files.
     *
     * readLine() returns null at end of file.
     */
    static void bufferedReaderWriter(Path dir)
            throws IOException {

        Path file = dir.resolve("lines.txt");

        try (BufferedWriter writer =
                     Files.newBufferedWriter(
                             file, StandardCharsets.UTF_8)) {

            writer.write("Java");
            writer.newLine();

            writer.write("Spring");
            writer.newLine();
        }

        try (BufferedReader reader =
                     Files.newBufferedReader(
                             file, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Java
            // Spring
        }
    }

    // =====================================================
    // 5. ByteArrayInputStream / ByteArrayOutputStream
    // =====================================================

    /*
     * PURPOSE:
     * Perform byte IO in memory.
     *
     * WHEN:
     * Testing, temporary binary data, preparing
     * a byte array before sending it elsewhere.
     *
     * No physical file is involved.
     */
    static void byteArrayStreams() throws IOException {

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        out.write(65);
        out.write(66);
        out.write(67);

        byte[] bytes = out.toByteArray();

        try (ByteArrayInputStream in =
                     new ByteArrayInputStream(bytes)) {

            System.out.println(in.read()); // 65 = 'A'
            System.out.println(in.read()); // 66 = 'B'
            System.out.println(in.read()); // 67 = 'C'
            System.out.println(in.read()); // -1 = EOF
        }
    }

    // =====================================================
    // 6. StringReader / StringWriter
    // =====================================================

    /*
     * PURPOSE:
     * Read/write characters in memory.
     *
     * WHEN:
     * Testing text-processing code or building text.
     *
     * StringReader -> reads from an existing String.
     * StringWriter -> accumulates characters.
     */
    static void stringReaderWriter() throws IOException {

        try (StringReader reader =
                     new StringReader("Java")) {

            System.out.println((char) reader.read());
            // J
        }

        StringWriter writer = new StringWriter();

        writer.write("Hello ");
        writer.write("NIO");

        System.out.println(writer.toString());
        // Hello NIO
    }

    // =====================================================
    // 7. DataInputStream / DataOutputStream
    // =====================================================

    /*
     * PURPOSE:
     * Read/write Java primitive values in binary format.
     *
     * WHEN:
     * A custom binary file format with known field order.
     *
     * IMPORTANT:
     * Read values in the SAME order and type
     * as they were written.
     */
    static void dataStreams() throws IOException {

        ByteArrayOutputStream bytes =
                new ByteArrayOutputStream();

        try (DataOutputStream out =
                     new DataOutputStream(bytes)) {

            out.writeInt(101);
            out.writeDouble(99.5);
            out.writeBoolean(true);
            out.writeUTF("Java");
        }

        try (DataInputStream in =
                     new DataInputStream(
                             new ByteArrayInputStream(
                                     bytes.toByteArray()))) {

            System.out.println(in.readInt());     // 101
            System.out.println(in.readDouble());  // 99.5
            System.out.println(in.readBoolean()); // true
            System.out.println(in.readUTF());     // Java
        }
    }

    // =====================================================
    // 8. PrintWriter / PrintStream
    // =====================================================

    /*
     * PURPOSE:
     * Convenient formatted text output.
     *
     * PrintWriter -> character-oriented output.
     * PrintStream -> byte-stream API with print methods.
     *
     * System.out is a PrintStream.
     *
     * IMPORTANT:
     * PrintWriter generally records IO errors internally.
     * Use checkError() when error detection matters.
     */
    static void printWriterExample(Path dir)
            throws IOException {

        Path file = dir.resolve("report.txt");

        try (PrintWriter writer = new PrintWriter(
                Files.newBufferedWriter(
                        file, StandardCharsets.UTF_8))) {

            writer.println("Employee Report");
            writer.printf("ID=%d, Name=%s%n", 101, "Raj");

            writer.flush();

            if (writer.checkError()) {
                throw new IOException("Writing report failed");
            }
        }

        System.out.println(Files.readString(file));
    }

    // =====================================================
    // 9. ObjectInputStream / ObjectOutputStream
    // =====================================================

    /*
     * PURPOSE:
     * Java object serialization/deserialization.
     *
     * Serializable is a MARKER INTERFACE.
     *
     * transient -> field is excluded from default
     *              serialization.
     *
     * serialVersionUID -> identifies serialized
     *                     class version compatibility.
     *
     * SECURITY:
     * Never deserialize untrusted input with
     * ObjectInputStream without appropriate safeguards.
     *
     * For many application data-exchange tasks,
     * JSON or another explicit format is preferable.
     */
    static class Employee implements Serializable {

        private static final long serialVersionUID = 1L;

        int id;
        String name;

        transient String password;

        Employee(int id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }
    }

    static void objectSerialization(Path dir)
            throws IOException, ClassNotFoundException {

        Path file = dir.resolve("employee.ser");

        Employee employee =
                new Employee(101, "Raj", "secret");

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             Files.newOutputStream(file))) {

            out.writeObject(employee);
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             Files.newInputStream(file))) {

            Employee restored =
                    (Employee) in.readObject();

            System.out.println(restored.id);       // 101
            System.out.println(restored.name);     // Raj
            System.out.println(restored.password); // null
        }
    }

    // =====================================================
    // 10. RandomAccessFile
    // =====================================================

    /*
     * PURPOSE:
     * Read/write at specific file positions.
     *
     * WHEN:
     * Updating a known position in a binary file.
     *
     * seek(position) moves the file pointer.
     *
     * Modes:
     * "r"  -> read only
     * "rw" -> read and write
     */
    static void randomAccessFile(Path dir)
            throws IOException {

        File file = dir.resolve("random.dat").toFile();

        try (RandomAccessFile raf =
                     new RandomAccessFile(file, "rw")) {

            raf.setLength(0); // Clear old contents.

            raf.writeInt(100);
            raf.writeInt(200);

            raf.seek(0); // Go to first int.
            System.out.println(raf.readInt()); // 100

            raf.seek(4); // int occupies 4 bytes.
            System.out.println(raf.readInt()); // 200
        }
    }

    // =====================================================
    // 11. Path / Paths / Files - NIO.2
    // =====================================================

    /*
     * PURPOSE:
     * Modern file and directory operations.
     *
     * Path  -> represents a path.
     * Paths -> older factory utility; Path.of() is modern.
     * Files -> reads, writes, copies, moves, deletes.
     *
     * WHEN:
     * Preferred for most modern Java file handling.
     *
     * Path does NOT itself open the file.
     */
    static void pathAndFiles(Path dir) throws IOException {

        Path file = dir.resolve("nio.txt");

        // Create/write a UTF-8 text file.
        Files.writeString(file, "Hello NIO");

        // Read entire text file.
        String text = Files.readString(file);

        System.out.println(text); // Hello NIO

        // Check whether the file exists.
        System.out.println(Files.exists(file)); // true

        // Copy a file.
        Path copy = dir.resolve("nio-copy.txt");

        Files.copy(file, copy,
                StandardCopyOption.REPLACE_EXISTING);

        // Move/rename a file.
        Path renamed = dir.resolve("renamed.txt");

        Files.move(copy, renamed,
                StandardCopyOption.REPLACE_EXISTING);

        // File size in bytes.
        System.out.println(Files.size(file)); // 9

        // Delete a file if it exists.
        Files.deleteIfExists(renamed);

        // Read small file as lines.
        List<String> lines = Files.readAllLines(file);

        System.out.println(lines); // [Hello NIO]

        /*
         * CAUTION:
         * readString(), readAllBytes(), readAllLines()
         * load the entire content into memory.
         *
         * For large files, use buffered or streaming IO.
         */
    }

    // =====================================================
    // 12. ByteBuffer / FileChannel - NIO
    // =====================================================

    /*
     * PURPOSE:
     * Channel transfers bytes.
     * Buffer temporarily stores bytes.
     *
     * ByteBuffer important methods:
     *
     * allocate(n) -> creates a buffer
     * put()       -> writes into buffer
     * flip()      -> switches from filling to reading
     * get()       -> reads from buffer
     * clear()     -> prepares for filling again
     * compact()   -> keeps unread data before refilling
     *
     * FileChannel supports file IO and positioning.
     *
     * NOTE:
     * FileChannel is not a non-blocking selectable channel.
     */
    static void fileChannelAndByteBuffer(Path dir)
            throws IOException {

        Path file = dir.resolve("channel.txt");

        try (FileChannel channel = FileChannel.open(
                file,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            ByteBuffer buffer = ByteBuffer.wrap(
                    "Hello Channel".getBytes(
                            StandardCharsets.UTF_8));

            // A write may be partial, so loop.
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
        }

        try (FileChannel channel = FileChannel.open(
                file, StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);

            if (count > 0) {

                // Switch buffer from write mode to read mode.
                buffer.flip();

                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);

                System.out.println(
                        new String(data, StandardCharsets.UTF_8));
                // Hello Channel
            }
        }
    }

    // =====================================================
    // 13. Files.walk / Files.list / File attributes
    // =====================================================

    /*
     * PURPOSE:
     * List directory contents and inspect metadata.
     *
     * Files.list() -> immediate children only.
     * Files.walk() -> recursive traversal.
     *
     * Returned streams must be closed.
     */
    static void fileAttributes(Path dir)
            throws IOException {

        try (Stream<Path> paths = Files.list(dir)) {

            paths.forEach(path ->
                    System.out.println(
                            path.getFileName()));
        }

        Path file = dir.resolve("nio.txt");

        BasicFileAttributes attributes =
                Files.readAttributes(
                        file, BasicFileAttributes.class);

        System.out.println(attributes.isRegularFile());
        // true

        System.out.println(attributes.size());
        // 9 bytes

        try (Stream<Path> paths = Files.walk(dir)) {

            long count = paths
                    .filter(Files::isRegularFile)
                    .count();

            System.out.println("File count: " + count);
        }
    }

    // =====================================================
    // 14. DirectoryStream
    // =====================================================

    /*
     * PURPOSE:
     * Iterate over entries in a directory.
     *
     * WHEN:
     * Listing files without loading all paths
     * into a List.
     *
     * Unlike Files.walk(), it is not recursive.
     */
    static void directoryStreamExample(Path dir)
            throws IOException {

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(dir, "*.txt")) {

            for (Path path : stream) {
                System.out.println(
                        "Text file: " + path.getFileName());
            }
        }
    }

    // =====================================================
    // 15. MappedByteBuffer
    // =====================================================

    /*
     * PURPOSE:
     * Memory-map a file region.
     *
     * WHEN:
     * Specialized random-access or large-file workloads.
     *
     * Mapping is not always the best choice:
     * resource lifetime and OS behavior matter.
     */
    static void mappedByteBufferExample(Path dir)
            throws IOException {

        Path file = dir.resolve("mapped.dat");

        try (FileChannel channel = FileChannel.open(
                file,
                StandardOpenOption.CREATE,
                StandardOpenOption.READ,
                StandardOpenOption.WRITE)) {

            MappedByteBuffer buffer = channel.map(
                    FileChannel.MapMode.READ_WRITE,
                    0,
                    4);

            buffer.putInt(12345);

            buffer.position(0);

            System.out.println(buffer.getInt());
            // 12345
        }
    }
}
