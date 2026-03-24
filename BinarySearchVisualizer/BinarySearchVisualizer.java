import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchVisualizer {

    /**
     * 探索結果をまとめるクラス
     */
    static class SearchResult {
        private final int index;
        private final List<String> steps;

        public SearchResult(int index, List<String> steps) {
            this.index = index;
            this.steps = steps;
        }

        public int getIndex() {
            return index;
        }

        public List<String> getSteps() {
            return steps;
        }
    }

    /**
     * 教育用の二分探索
     * - target が見つかればその index を返す
     * - 見つからなければ -1 を返す
     * - 途中の探索手順を steps に保存する
     */
    public static SearchResult binarySearchWithSteps(int[] arr, int target) {
        List<String> steps = new ArrayList<>();

        int left = 0;
        int right = arr.length - 1;

        steps.add("探索開始");
        steps.add("配列: " + Arrays.toString(arr));
        steps.add("目標値: " + target);

        while (left <= right) {
            int mid = (left + right) / 2;

            steps.add("----------------------------------");
            steps.add("left=" + left + ", right=" + right + ", mid=" + mid);
            steps.add("arr[mid]=" + arr[mid]);

            if (arr[mid] == target) {
                steps.add("arr[mid] == target → 見つかった");
                steps.add("結果: index " + mid);
                return new SearchResult(mid, steps);
            } else if (arr[mid] < target) {
                steps.add("arr[mid] < target → 目標値はもっと右");
                steps.add("left を mid + 1 に移動");
                left = mid + 1;
            } else {
                steps.add("arr[mid] > target → 目標値はもっと左");
                steps.add("right を mid - 1 に移動");
                right = mid - 1;
            }
        }

        steps.add("----------------------------------");
        steps.add("left > right になったため探索終了");
        steps.add("結果: 見つからなかった");

        return new SearchResult(-1, steps);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;

        SearchResult result = binarySearchWithSteps(numbers, target);

        System.out.println("=== Binary Search Visualizer ===");
        for (String step : result.getSteps()) {
            System.out.println(step);
        }

        System.out.println();
        if (result.getIndex() != -1) {
            System.out.println("最終結果: " + target + " は index " + result.getIndex() + " にあります。");
        } else {
            System.out.println("最終結果: " + target + " は見つかりませんでした。");
        }
    }
}