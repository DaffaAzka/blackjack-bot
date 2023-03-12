import java.util.*

var cards = mutableListOf(0);
var totalCards = 0;
var input = Scanner(System.`in`)
var moneyEarned = 0


fun main() {

    print("how many rounds do you want: ")
    var rounds = input.nextInt()

    print("how much money do you want to input: ")
    var money = input.nextInt()

    var moneyRound = money / rounds;


    for(i in 1..rounds) {
        totalCards = 0
        startGame()

        while(true) {

            if(totalCards > 22) {
                println(":You lose!")
                moneyEarned += winLose(moneyRound, false)
                println("====================================")
                break;
            } else if(totalCards == 22) {
                println(":You got the Jackpot!")
                moneyEarned += winLose(moneyRound, true)
                money += 300
                println("====================================")
                break;
            } else {
                println("Draw a new Card...")
                drawNewCard()
            }

        }

    }

    println("Total money you get: $moneyEarned")
}

fun startGame() {
    cards = mutableListOf(0);
    cards.add((2..12).random())
    cards.add((2..12).random())
    println(cards)
    sumTheCards()
}

fun drawNewCard() {
    cards.add((2..12).random())
    print(cards)
    sumTheCards()
    println(" = $totalCards")
}

fun sumTheCards() {
    totalCards = 0;
    for(card:Int in cards) {
        totalCards += card
    }
}

fun winLose(v: Int, s: Boolean): Int {
    return if (s) {
        v * 3;
    } else {
        0;
    }
}