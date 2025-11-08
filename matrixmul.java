public class matrixmul{
    public static void main(String[] args) {
        int[][] matrixA={{63,99},//0
                        {58,83}};
        int[][] matrixB={{99,23},
                        {-96,0}};
        int sum=0;
        if(matrixA[0].length==matrixB.length){
        for(int x=0;x<matrixA.length;x++){
        for(int y=0;y<matrixB[1].length;y++){
        sum=0;
        for(int k=0;k<matrixB.length;k++){
        sum+= matrixA[x][k]*matrixB[k][y];
    }
    System.out.print(sum);
    
}
}}
else{
    System.out.println("THere is no way This is possible Dumbo");
}

}
}