import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ForthCompiler {

    public static void main(String[] args) {

        String readFilePath = args[0];
        String writeFilePath = "main.s";

        try {
            FileReader fileReader = new FileReader(readFilePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter writer = new FileWriter(writeFilePath);

            writer.write(".section .text" + "\n");
            writer.write(".global _start" + "\n");
            writer.write("_start:" + "\n");

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] items = line.split(" ");

                for (String item : items){
                       if(checkNumber(item)){
                            writer.write("pushq $" + item + "\n");
                       }
                       else if(item.equals("+")){
                           writer.write("popq %rbx" + "\n");
                           writer.write("popq %rax" + "\n");
                           writer.write("addq %rbx, %rax" + "\n");
                           writer.write("pushq %rax" + "\n");
                       } else if (item.equals("-")) {
                           writer.write("popq %rbx" + "\n");
                           writer.write("popq %rax" + "\n");
                           writer.write("subq %rbx, %rax" + "\n");
                           writer.write("pushq %rax" + "\n");
                       } else if (item.equals("*")) {
                           writer.write("popq %rbx" + "\n");
                           writer.write("popq %rax" + "\n");
                           writer.write("mulq %rbx" + "\n");
                           writer.write("pushq %rax" + "\n");
                       } else if (item.equals("swap")) {
                           writer.write("popq %rbx" + "\n");
                           writer.write("popq %rax" + "\n");
                           writer.write("pushq %rbx" + "\n");
                           writer.write("pushq %rax" + "\n");
                       } else if (item.equals("nip")) {
                           writer.write("popq %rbx" + "\n");
                           writer.write("popq %rax" + "\n");
                           writer.write("pushq %rbx" + "\n");
                       } else if (item.equals("tuck")) {
                           writer.write("popq %rbx" + "\n");
                           writer.write("popq %rax" + "\n");
                           writer.write("pushq %rbx" + "\n");
                           writer.write("pushq %rax" + "\n");
                           writer.write("pushq %rbx" + "\n");
                       } else if (item.equals("dup")) {
                           writer.write("popq %rbx" + "\n");
                           writer.write("pushq %rbx" + "\n");
                           writer.write("pushq %rbx" + "\n");
                       } else if (item.equals("drop")) {
                           writer.write("popq %rbx" + "\n");
                       } else if (item.equals("over")) {
                           writer.write("popq %rbx" + "\n");
                           writer.write("popq %rax" + "\n");
                           writer.write("pushq %rax" + "\n");
                           writer.write("pushq %rbx" + "\n");
                           writer.write("pushq %rax" + "\n");
                       } else if (item.equals(".")) {
			   writer.write("popq %rsi\n");
                           writer.write("call print\n");
                       }

                }

            }
		
	    writer.write("exit:\n");
            writer.write("\n\tmov $60,%rax\n");
            writer.write("\t\txor %rdi, %rdi\n");
            writer.write("\tsyscall");

            writer.close();
            bufferedReader.close();
            fileReader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static boolean checkNumber(String s){
        try {
            int number = Integer.parseInt(s);
            return true;// Successful conversion
        } catch (NumberFormatException e) {
            return false;// String is not a valid integer
        }

    }

}

