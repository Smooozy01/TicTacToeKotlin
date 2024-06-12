fun main(){
    
    val playField = Array(3) {IntArray(3)}
    
    var turnPlayer = 1
    
    displayField(playField)
    
    while (true){
        
        println(turnPlayer)
        
        turnPlayer = move(playField, turnPlayer)
        
        if (checkForWin(playField)){
            println("Game Over!")
            return
        }
        
        
        turnPlayer = move(playField, turnPlayer)
        
        if (checkForWin(playField)){
            println("Game Over!")
            return
        }
        
    }
    
    
}

fun move(playField: Array<IntArray>, turn: Int): Int {
    
    val move1 = readln().toInt() - 1
    val move1Row = move1 / 3
    val move1Column = move1 % 3
    
    if (playField[move1Row][move1Column] != 0){
        println("This place is occupied!")
        return move(playField, turn)
    }
    
    playField[move1Row][move1Column] = turn
    
    displayField(playField)
    
    if (turn == 1){ return 2}
    else return 1
    
}


fun checkForWin(playField: Array<IntArray>):Boolean {
    
    if (checkHorizontally(playField, 1) || checkHorizontally(playField, 2)) return true
    if (checkVertically(playField, 1) || checkVertically(playField, 2)) return true
    if (checkCross(playField, 1) || checkCross(playField, 2)) return true
    
    return false
    
}


fun checkCross(playField: Array<IntArray>, player: Int):Boolean {
    
    
    if (playField[0][0] == player && playField[1][1] == player && playField[2][2] == player){ return true }
    
    if (playField[0][2] == player && playField[1][1] == player && playField[2][0] == player){ return true }
    
    return false
    
}


fun checkHorizontally(playField: Array<IntArray>, player: Int): Boolean {
    
    for (i in 0..2){
        
        if (playField[i][0] == player && playField[i][1] == player && playField[i][2] == player) return true
        
    }
    return false
    
}


fun checkVertically(playField: Array<IntArray>, player: Int): Boolean {
        
    for (i in 0..2){
        
        if (playField[0][i] == player && playField[1][i] == player && playField[2][i] == player) return true
        
    }
    return false
    
}


fun displayField(playField: Array<IntArray>) {
    
    for (i in 0..2) {
        
        for (j in 0..2) {
            
            print("${playField[i][j]} ")
            
        }
        print("\n")
        
    }
    println("\n")    
    
   
    
    
    
}






