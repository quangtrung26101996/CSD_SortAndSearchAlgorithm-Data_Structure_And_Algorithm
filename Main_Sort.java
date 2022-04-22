import java.util.Scanner;

/**
 * Sort, Search algorithm basic
 * 
 * @author Vu Quang Trung - FX14135
 */

public class Main_Sort {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int choice;
        float[] arr = new float[0];
        float[] b = new float[0];
        float value;
        // Chọn chức năng cho ứng dụng
        do {
            menu();
            System.out.print("Choose your option (0 - 7): ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Array length is ");
                    int arrayLength = input.nextInt();
                    arr = new float[arrayLength];
                    // Nhập dữ liệu và lưu vào mảng arr
                    inputData(input, arr);
                    // Ghi dữ liệu vào file "INPUT.txt"
                    Algorithm.writeFile("INPUT.txt", arr);
                    break;
                case 2:
                    System.out.println("Read from file INPUT.txt");
                    System.out.print("Array: ");
                    // Đọc dữ liệu từ file "INPUT.txt" lưu vào mảng arr và hiển thị ra màn hình
                    // console
                    Algorithm.readFile("INPUT.txt", arr);
                    break;
                case 3:
                    System.out.println("Bubble Sort");
                    // Sắp xếp và trả về mảng "b" bằng thuật toán Bubble Sort
                    b = Algorithm.bubbleSort(arr);
                    // Ghi mảng "b" vào file "OUTPUT1.txt"
                    Algorithm.writeFile("OUTPUT1.txt", b);
                    break;
                case 4:
                    System.out.println("Selection Sort");
                    // Sắp xếp và trả về mảng "b" bằng thuật toán Selection Sort
                    b = Algorithm.selectionSort(arr);
                    // Ghi mảng "b" vào file "OUTPUT2.txt"
                    Algorithm.writeFile("OUTPUT2.txt", b);
                    break;
                case 5:
                    System.out.println("Insertion Sort");
                    // Sắp xếp và trả về mảng "b" bằng thuật toán Insertion Sort
                    b = Algorithm.insertionSort(arr);
                    // Ghi mảng "b" vào file "OUTPUT3.txt"
                    Algorithm.writeFile("OUTPUT3.txt", b);
                    break;
                case 6:
                    System.out.println("Linear Search");
                    System.out.print("Input value: ");
                    value = input.nextFloat();
                    // Trả về kết quả tìm kiếm tuyến tính
                    String resultLinearSearch = Algorithm.linearSearch(arr, value);
                    if (resultLinearSearch == "") {
                        System.out.println("Not found element !");
                        // Ghi kết quả vào file "OUTPUT4.txt"
                        Algorithm.writeFileLinearSearch("OUTPUT4.txt", "Not found element !");
                    } else {
                        System.out.println(resultLinearSearch);
                        // Ghi kết quả vào file "OUTPUT4.txt"
                        Algorithm.writeFileLinearSearch("OUTPUT4.txt", resultLinearSearch);
                    }
                    break;
                case 7:
                    System.out.println("Binary Search");
                    System.out.print("Input value: ");
                    value = input.nextFloat();
                    // Trả về kết quả tìm kiếm nhị phân
                    int resultBinarySearch = Algorithm.binarySearch(b, value);
                    if (resultBinarySearch == -1) {
                        System.out.println("Not found element !");
                        // Ghi kết quả vào file "OUTPUT5.txt"
                        Algorithm.writeFileLinearSearch("OUTPUT5.txt", "Not found element !");
                    } else {
                        System.out.println("Index of first element: " + resultBinarySearch);
                        // Ghi kết quả vào file "OUTPUT5.txt"
                        Algorithm.writeFileBinarySearch("OUTPUT5.txt", resultBinarySearch);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice ! Try again.");
                    break;
            }
        } while (choice != 0);
        input.close();
        System.out.println("Tks you !");
    }

    /**
     * Hiển thị menu các chức năng
     */

    public static void menu() {
        System.out.println("------ Menu ------");
        System.out.println("1. Input");
        System.out.println("2. Output");
        System.out.println("3. Bubble sort");
        System.out.println("4. Selection sort");
        System.out.println("5. Insertion sort");
        System.out.println("6. Search > value");
        System.out.println("7. Search = value");
        System.out.println("0. Exit");
    }

    /**
     * Nhập giá trị và lưu vào mảng arr
     * 
     * @param input Scanner
     * @param arr   mảng arr
     */
    public static void inputData(Scanner input, float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Value of index " + i + " is ");
            arr[i] = input.nextFloat();
        }
    }
}
