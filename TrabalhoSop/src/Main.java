
public class Main {

	public static int ramdon(int[][] dados){
		int [] pages = new int[dados.length];
		int result = 0;
		for(int i = 0; i < dados.length ; i++){
			for(int j = 0; j < dados.length; j++){
				if(j == 0){
					pages[i] = dados[i][j]; 
				}
			}
		}
		int numAleatorio = (int)(Math.random() * dados.length ) + 1;
		for(int i = 0; i < pages.length; i++){
			if(pages[i] == numAleatorio){
				result = pages[i];
				break;
			}
		}
		return result;
	}
	/*
	public int fifo(int[][] dados){
		return int;
	}
	*/
	public static int nru(int[][] dados){
		int result = 0;
		boolean condition = false;
		for(int i = 0; i < dados.length ; i++){
			for(int j = 0; j < dados[i].length; j++){
				if(j == ((dados[i].length)) && dados[i][j] == 0 && dados[i][j-1] == 0 ){
					result = i;
					condition = true;
					break;
				}else if(j == ((dados[i].length) - 1) && dados[i][j] == 0){
					result = i;
					condition = true;
					break;
				}else{
					result = i;
				}
			}
			if(condition){
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][]dados = {{1, 128, 279, 1, 1}, {0, 230, 260, 1, 1},
								{3, 120, 272, 1, 1}, {2, 160, 280, 1, 1}};
		
		//System.out.println(ramdon(dados));
		System.out.println(nru(dados));
		System.out.println(dados.length);

	}

}
