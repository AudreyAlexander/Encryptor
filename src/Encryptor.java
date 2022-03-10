public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        String[] splitString = str.split("");
        int count = 0;

        if (str.length() > numRows*numCols){
            String origStr = str;
            str = str.substring(0, str.length()-(numRows*numCols)-1);
        }

        for (int i = 0; i < letterBlock.length; i++){
            for (int k = 0; k < letterBlock[0].length; k++){
                if(count > str.length()){
                    letterBlock[i][k] = "A";
                }
                else{
                    letterBlock[i][k] = splitString[count];
                    count++;
                }

            }
        }

    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String finalMessage = "";
        for (int i = 0; i < letterBlock.length; i++){
            for (int k = 0; k < letterBlock[0].length; k++){
                finalMessage += letterBlock[k][i];
            }
        }
        return finalMessage;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        String encryptedString = "";
        int strLength = message.length();
        int blockLength = numRows * numCols;
        if (blockLength < strLength){
            for (int i = 0; i < strLength; i += blockLength){
                String newString = message.substring(i, blockLength);
                fillBlock(message);
                encryptedString += encryptBlock();
            }
        }
        return encryptedString;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage) {
        /*String decryptedMessage = "";
        String[] messageList = encryptedMessage.split("");
        fillBlock(decryptedMessage);


        /*int blockSize = numRows*numCols;
        if (messageList.length > blockSize){
            int counter = 0;
            int decryptedMessageLength = decryptedMessage.length();
            while (decryptedMessageLength != 0){
                decryptedMessageLength -= blockSize;
                counter++;
            }
            for(int i = 0; i < blockSize*counter; i+=blockSize){

            }*/


        /*}
        else if (messageList.length < blockSize){
            int count = 0;
            String[][] decrypted = new String[numRows][numCols];
            for (int i = 0; i < decrypted.length; i++) {
                for (int k = 0; k < decrypted[0].length; k++) {
                    if(count > messageList.length){
                        decrypted[i][k] = "A";
                    }
                    else{
                        decrypted[i][k] = messageList[count];
                    }
                    count++;
                }
            }
            for (int i = 0; i < decrypted.length; i++){
                for (int k = 0; k < decrypted[0].length; k++){
                    decryptedMessage += decrypted[k][i];
                }
            }
        }

        for (int i = decryptedMessage.length(); i > 0; i--){
            if (decryptedMessage.substring(i, i-1).equals("A")){
                decryptedMessage = decryptedMessage.substring(0, i);
            }
        }

        return decryptedMessage;
        */
        return "hi";
    }



}