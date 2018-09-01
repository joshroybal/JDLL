import java.io.*;
   
class TestNode
{  public static void main(String args[]) throws IOException
   {  if (args.length == 0)
      {  System.err.println(" Usage: java TestNode filename");
         System.exit(1);
      }
      textReadFile(args[0]);
      // Node.print();
      // Node.print_();
      Node.serialize();
      Node.destroy();
      Node.print();
      Node.deserialize();
      // Node.print();
      // Node.print_();
   }

   public static void textReadFile(String filename) throws IOException
   {  File infile = new File(filename);
      FileReader fr = new FileReader(infile);
      BufferedReader br = new BufferedReader(fr);

      String line;
      while ((line = br.readLine()) != null)
      {  int tabidx = line.indexOf('\t');
         String key = line.substring(0, tabidx);
         String data = line.substring(tabidx + 1);
         new Node(key, data);
      }

      br.close();
      fr.close();

      System.out.println("text data read");
   }
}
