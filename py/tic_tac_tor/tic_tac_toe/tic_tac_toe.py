

board = {}
for i in range(1,4):
    for j in range(1,4):
        board.update({"{coulumn}-{row}".format(coulumn=str(i),row=str(j)):"-"})

def main():

    global board
    player1 = "X"
    player2 = "O"
    blank = "-"

    def turn(player,column,row):
        global board
        board.update({"{coulumn}-{row}".format(coulumn=str(column),row=str(row)):str(player)})

    def check(player):
        global board
        for checker in board:
            bvalues = board.values()
            print(board[checker])
        print(bvalues)
        


    for playerTurn in range(0,11):
        if playerTurn % 2 == 0:
            player = player1
        elif playerTurn % 2 == 1:
            player = player2
        try:
            column,row = input("Choose a spot on the board: (column(1-3),row(1-3)) ").split(",")
            if board["{column}-{row}".format(column=str(column),row=str(row))] == blank:
                turn(player=player,column=column,row=row)
            else:
                print("This block is not empty! ")
        except Exception as e:
                print(e)
        
        for row in range(1,4):
            for column in range(1,4):
                if column == 3:
                    endpoint = "\n"
                else:
                    endpoint = ""
                print(board["{column}-{row}".format(column=str(column),row=str(row))],end=endpoint)
        
        check(player)
        print(board)

main()