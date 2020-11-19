package encryptdecrypt;

import java.io.File;
import java.io.IOException;
//pattern strategy
//Создание шифратора/дешифратора с возможностью ввода информации в командную строку
//или через файл и вывода в командную строку или в файл.
//представлены 2 вида шифрования с помощью ключа: 1.с помощью unicode все символы
//2. только буквенные символы с помощью английского алфавита. Причем, если предоставленная буква
//прописная,то шифруется она только в прописную, такой же алгоритм со строчной буквой

public class Main {
    public static void main(String[] args) throws IOException {
        String mode = "enc";     //Если -mode нет , программа должна работать в режиме enc
        String alg = "shift";    //shift - сдвиг только букв по англ алфавиту(a-z-A-Z),unicode - сдвиг всех символов по unicode,
        int key = 0;             //Если -key нет , программа должна считать, что ключ = 0
        String data = "";        //Если -data нет , программа должна предположить, что данные представляют собой пустую строку.
        File input_path = null;  //Если оба -data и in - аргументов, программа должна предпочесть -data над -in .
        File output_path = null; //Если аргумент -out отсутствует , программа должна вывести данные на стандартный вывод.

        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-alg":
                    alg = args[i + 1]; // если есть -alg, то сохраняем его значение
                    break;
                case "-in":
                    input_path = new File(args[i + 1]);  // если есть in, то создем объект File
                    if (!input_path.exists())            //проверка на существование файла
                        input_path.createNewFile();      //создание файла
                    break;
                case "-out":
                    output_path = new File(args[i + 1]); // если есть out, то создем объект File
                    if (!output_path.exists())            //проверка на существование файла
                        output_path.createNewFile();     //создание файла
                    break;
                case "-mode":
                    mode = args[i + 1]; // если есть -mode, то сохраняем его значение
                    break;
                case "-key":
                    try {
                        key = Integer.parseInt(args[i + 1]); // если есть -key, то переводим его в Integer и сохраняем его значение
                    } catch (NumberFormatException e) {   // вывод ошибки,если невозможен перевод в число
                        System.out.println("Key has to consist of digits");
                    }
                    break;
                case "-data":
                    data += args[i + 1];
                    input_path = null; //данные вводимые в консоль при запуске
                    break;
            }

        }
        Coding coding = new Coding(mode, alg, key, data, input_path, output_path);
        coding.switchMode();

    }


}


