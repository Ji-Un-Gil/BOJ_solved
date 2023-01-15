import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Document {

    private int docNum;
    private int docPriority;

    public Document(int docNum, int docPriority) {
        this.docNum = docNum;
        this.docPriority = docPriority;
    }

    public int getDocNum() {
        return docNum;
    }

    public int getDocPriority() {
        return docPriority;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        int N, target, docNum, printedDocs;
        Deque<Document> documentPriorityQueue;
        PriorityQueue<Integer> priorityQueue;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcases = Integer.parseInt(br.readLine());
        while (testcases > 0) {
            documentPriorityQueue = new ArrayDeque<>();
            priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            docNum = 0;
            printedDocs = 1;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            while (N > 0) {
                int priority = Integer.parseInt(st.nextToken());
                priorityQueue.add(priority);
                documentPriorityQueue.add(new Document(docNum, priority));
                docNum++;
                N--;
            }

            while (!documentPriorityQueue.isEmpty()) {
                Document document = documentPriorityQueue.poll();
                if (document.getDocPriority() < priorityQueue.peek()) {
                    documentPriorityQueue.add(document);
                    continue;
                }
                if (document.getDocNum() == target) {
                    System.out.println(printedDocs);
                    break;
                }
                priorityQueue.poll();
                printedDocs++;
            }
            testcases--;
        }
    }
}
