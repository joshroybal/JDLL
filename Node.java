import java.io.*;

class Node
{  private String key;
   private String data;
   private Node prev;
   private Node next;
   
	static Node head;
   static Node tail;

   static void print()
   {  Node node = head;
      if (node == null) System.out.println("empty list");
      else do
      {  System.out.println(node);
         node = node.next;
      } while (node != null);
   }

   static void print_()
   {  Node node = tail;
      while (node != null)
      {  System.out.println(node);
         node = node.prev;
      }
   }

   public static void serialize() throws IOException
   {  File outfile = new File("list.txt");
      FileWriter fw = new FileWriter(outfile);
      BufferedWriter bw = new BufferedWriter(fw);

      Node node = tail;
      while (node != null)
      {  bw.write(node.key + "\t" + node.data);
         bw.newLine();
         node = node.prev;
      }

      bw.close();
      fw.close();

      System.out.println("linked list serialized");
   }

   public static void deserialize() throws IOException
   {  File infile = new File("list.txt");
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

      System.out.println("linked list deserialized");
   }
	
	static void destroy()
	{	head = null;
      tail = null;
	}

   Node(String key, String data)
   {  this.key = key;
      this.data = data;
      this.prev = null;
      this.next = null;
      if (head == null) 
      {  head = this;
         tail = this;
      }
      else if (head.key.compareTo(key) > 0)
      {  next = head;
         head.prev = this;
         head = this;
      }
      else
      {  Node p = head;
         Node q = p.next;
         while (q != null && q.key.compareTo(key) < 0)
         {  p = q;
            q = q.next;
         }
         p.next = this;
         prev = p;
         next = q;
         if (next == null) 
            tail = this;
         else
            q.prev = this;
      }
   }

   public String toString()
   {  return new String(key + ":\t" + data);
   }
}
