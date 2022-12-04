package InterfaceShop.service;

public class HCG {
    String word;
    int hashCode;

    public HCG(String word){
        this.word = word;
        this.hashCode = customHashCodeGenerator(word);

    }

    public int getHCG() {
        return this.hashCode;
    }

    public int customHashCodeGenerator(String word) {
        int productID = 0;
        for(int i = 0; i < word.length(); i++) {
            int temp = word.charAt(i) * 5;
            temp += 13;
            temp += (int)Math.sqrt(word.charAt(i)) * 3;
            productID += temp;
            temp = 0;
        }
        return productID;
    }
}
