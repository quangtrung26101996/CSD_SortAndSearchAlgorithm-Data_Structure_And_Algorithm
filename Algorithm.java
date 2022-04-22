import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm {

    /**
     * Ghi dữ liệu từ array vào file text
     * 
     * @param fileName tên file được lưu dữ liệu vào
     * @param arr      mảng dữ liệu đầu vào
     * 
     */

    public static void writeFile(String fileName, float[] arr) {
        try {
            // Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);
            // Ghi dữ liệu
            for (int i = 0; i < arr.length; i++) {
                dos.writeBytes(arr[i] + " ");
            }
            // Đóng luồng
            dos.close();
            System.out.println("Array saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error !");
        }
    }

    /**
     * Đọc dữ liệu từ file lưu vào mảng và hiển thị dữ liệu từ mảng ra màn hình
     * console
     *
     * @param fileName tên file được đọc dữ liệu
     *
     */
    public static void readFile(String fileName, float[] arr) {
        try {
            // Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            // Đọc dữ liệu từ file và lưu vào mảng arr
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] row = line.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Float.parseFloat(row[i]);
                }
            }
            // Hiển thị dữ liệu mảng arr ra màn hình console
            display(arr);
            // Đóng luồng
            dis.close();
        } catch (IOException e) {
            System.out.println("Error !");
        }
    }

    /**
     * In mảng ra màn hình console
     * 
     * @param arr mảng được in ra
     */

    public static void display(float[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println(" ]");
    }

    /**
     * Đổi chỗ 2 element trong array
     * 
     * @param arr mảng dữ liệu đầu vào
     * @param i   chỉ số của phần tử được đổi
     * @param j   chỉ số của phần tử được đổi
     */

    public static void swap(float[] arr, int i, int j) {
        float temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Sao chép mảng trả lại mảng "b"
     * 
     * @param arr mảng dữ liệu đầu vào
     * @return trả lại mảng "b" được sao chép
     */

    public static float[] copyArray(float[] arr) {
        float[] b = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            b[i] = arr[i];
        }
        return b;
    }

    /**
     * Sắp xếp theo thuật toán Bubble Sort
     * 
     * @param arr mảng dữ liệu đầu vào
     * @return trả lại mảng "b" đã được sắp xếp
     */

    public static float[] bubbleSort(float[] arr) {
        float[] b = copyArray(arr);
        display(b);
        int n = b.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (b[j] > b[j + 1]) {
                    swap(b, j, j + 1);
                }
                display(b);
            }
        }
        return b;
    }

    /**
     * Sắp xếp theo thuật toán Selection Sort
     * 
     * @param arr mảng dữ liệu đầu vào
     * @return trả lại mảng "b" đã được sắp xếp
     */

    public static float[] selectionSort(float[] arr) {
        float[] b = copyArray(arr);
        display(b);
        int i, j, minIndex;
        for (i = 0; i <= b.length - 2; i++) {
            minIndex = i;
            for (j = i + 1; j <= b.length - 1; j++) {
                if (b[j] < b[minIndex]) {
                    minIndex = j;
                }
            }
            swap(b, minIndex, i);
            display(b);
        }
        return b;
    }

    /**
     * Sắp xếp theo thuật toán Insertion Sort
     * 
     * @param arr mảng dữ liệu đầu vào
     * @return trả lại mảng "b" được sắp xếp
     */

    public static float[] insertionSort(float[] arr) {
        float[] b = copyArray(arr);
        display(b);
        int i, j;
        float current;
        for (i = 0; i <= b.length - 1; i++) {
            current = b[i];
            j = i - 1;
            while (j >= 0 && b[j] > current) {
                b[j + 1] = b[j];
                j--;
            }
            b[j + 1] = current;
            display(b);
        }
        return b;
    }

    /**
     * Tìm kiếm tuyến tính các phần tử và giá trị lớn hơn "value"
     * 
     * @param arr   mảng dữ liệu đầu vào
     * @param value giá trị nhập vào để tìm kiếm
     * @return trả lại chuỗi đã tìm kiếm
     */

    public static String linearSearch(float[] arr, float value) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                result += "Index: " + i + " - Value: " + arr[i] + "\n";
            }
        }
        return result;
    }

    /**
     * Ghi kết quả tìm kiếm tuyến tính vào file text
     * 
     * @param fileName           tên file được lưu kết quả
     * @param resultLinearSearch kết quả tìm kiếm tuyến tính
     */

    public static void writeFileLinearSearch(String fileName, String resultLinearSearch) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes(resultLinearSearch);
            dos.close();
        } catch (IOException e) {
            System.out.println("Error !");
        }
    }

    /**
     * Tìm kiếm nhị phân phần tử trong mảng bằng giá trị "value"
     * 
     * @param arr   mảng dữ liệu đầu vào
     * @param value giá trị cần tìm kiếm
     * @return trả lại kết quả tìm kiếm
     */

    public static int binarySearch(float[] arr, float value) {
        int lowerBound = 0;
        int upperBound = arr.length - 1;
        int midPoint;
        int indexValue = 0;
        boolean isSearching = true;
        while (isSearching) {
            // index của phần tử ở giữa mảng
            midPoint = (upperBound + lowerBound) / 2;
            if (upperBound < lowerBound) {
                indexValue = -1;
                isSearching = false;
            }
            // Nếu value < giá trị ở giữa,
            if (arr[midPoint] > value) {
                upperBound = midPoint - 1;
            } else if (arr[midPoint] < value) {
                lowerBound = midPoint + 1;
            } else {
                indexValue = midPoint;
                isSearching = false;
            }
        }
        return indexValue;
    }

    /**
     * Ghi kết quả tìm kiếm nhị phân vào file text
     * 
     * @param fileName           tên file được lưu kết quả
     * @param resultBinarySearch kết quả tìm kiếm nhị phân
     */

    public static void writeFileBinarySearch(String fileName, int resultBinarySearch) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeBytes("Index of first element: " + resultBinarySearch);
            dos.close();
        } catch (IOException e) {
            System.out.println("Error !");
        }
    }
}
