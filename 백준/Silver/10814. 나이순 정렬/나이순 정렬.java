import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        List<Person> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        String[] inputData;
        for (int i = 0; i < N; i++) {
            inputData = br.readLine().split(" ");
            arr.add(new Person(Integer.valueOf(inputData[0]), inputData[1]));
        }
        
        arr.sort((a, b) -> a.getAge() - b.getAge());
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)).append("\n");
        }
        
        System.out.print(sb);
        
    }
}

class Person {
    private int age;
    private String name;
    
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return age + " " + name;
    }
}