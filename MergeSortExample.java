package merge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MergeSortExample extends RecursiveTask<List<Integer>> {

    List<Integer> array;

    public MergeSortExample(List<Integer> list) {
        this.array = list;
    }

    @Override
    protected List<Integer> compute() {
        if (array.size() < 2) {
            return array;
        }

        int length = array.size();
        int mid = length/2;
        List<Integer> first = new ArrayList<>(array.subList(0, mid));
        List<Integer> second = new ArrayList<>(array.subList(mid, length));
        MergeSortExample t1 = new MergeSortExample(first);
        MergeSortExample t2 = new MergeSortExample(second);
        t1.fork();
        t2.fork();

        first = t1.join();
        second = t2.join();

        int i = 0;
        int j = 0;
        int slen = length - mid;
        List<Integer> result = new ArrayList<>();
        while ((i < mid) && (j < slen)) {
            Integer v1 = first.get(i);
            Integer v2 = second.get(j);
            if (v1 < v2) {
                result.add(v1);
                i++;
            }
            else {
                result.add(v2);
                j++;
            }
        }

        while(i < mid) {
            result.add(first.get(i));
            i++;
        }

        while(j < slen) {
            result.add(second.get(j));
            j++;
        }

        return result;
    }
}
