import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StatsObj {
    private HashMap<String, Integer> data;
    private ArrayList<String> mostFreq;
    private int size = 0;
    private int n;

    public StatsObj(int var1) {
        this.n = var1;
        this.data = new HashMap();
        this.mostFreq = new ArrayList();
    }

    public int getCountOf(String var1) {
        return this.data.containsKey(var1) ? (Integer) this.data.get(var1) : 0;
    }

    public int size() {
        return this.size;
    }

    public void add(String var1) {
        ++this.size;
        if (this.data.containsKey(var1)) {
            int var2 = this.data.get(var1);
            this.data.put(var1, var2 + 1);
        } else {
            this.data.put(var1, 1);
        }

        this.updateMostFrequentWith(var1);
    }

    private void updateMostFrequentWith(String var1) {
        if (this.mostFreq.contains(var1)) {
            this.mostFreq.remove(var1);
        }

        int var2 = this.indexToInsertAt(var1);
        this.mostFreq.add(var2, var1);
        if (this.mostFreq.size() > this.n) {
            this.mostFreq.remove(this.mostFreq.size() - 1);
        }

    }

    private int indexToInsertAt(String var1) {
        for (int var2 = 0; var2 < this.mostFreq.size(); ++var2) {
            if (this.getCountOf(var1) > this.getCountOf(this.mostFreq.get(var2))) {
                return var2;
            }
        }

        return this.mostFreq.size();
    }

    public String getMostFrequent() {
        return this.mostFreq.get(0);
    }

    public List<String> getTopMostFreq() {
        return Collections.unmodifiableList(this.mostFreq);
    }

    /**
     * @return
     */
    public String getRandom() {
        int var1 = (int) (Math.random() * this.size());
        if (this.data.keySet().isEmpty()) {
            System.out.println("WARNING: statsobj contains no data");
            return null;
        } else {
            int var2 = 0;
            Iterator var3 = this.data.keySet().iterator();

            String var4;
            do {
                if (!var3.hasNext()) {
                    return "ERROR in getRandom()!";
                }

                var4 = (String) var3.next();
                var2 += this.data.get(var4);
            } while (var1 >= var2);

            return var4;
        }
    }

    public String toString() {
        return this.data.toString();
    }
}
