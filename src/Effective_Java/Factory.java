package Effective_Java;

/**
 * Created by tonytan on 20/11/2016.
 */
public class Factory {

    private final int requiredOne;
    private final int requiredTwo;
    private final int optionalOne;
    private final int optionalTwo;
    private final int optionalThree;

    public static class Builder{
        //required params
        private final int requiredOne;
        private final int requiredTwo;

        // optional params
        private int optionalOne = 0;
        private int optionalTwo = 0;
        private int optionalThree = 0;

        public Builder(int requiredOne, int requiredTwo){
            this.requiredOne = requiredOne;
            this.requiredTwo = requiredTwo;
        }

        public Builder optionalOne(int value){
            optionalOne = value;
            return this;
        }

        public Builder optionalTwo(int value){
            optionalTwo = value;
            return this;
        }

        public Builder optionalThree(int value){
            optionalThree = value;
            return this;
        }
    }

    private Factory(Builder builder){
        requiredOne = builder.requiredOne;
        requiredTwo = builder.requiredTwo;
        optionalOne = builder.optionalOne;
        optionalTwo = builder.optionalTwo;
        optionalThree = builder.optionalThree;
    }


    public static void main(String[] args){
        Builder builder = new Builder(1,2);
        builder.optionalOne(1).optionalTwo(2).optionalThree(3);
        Factory factory = new Factory(builder);
    }

}
