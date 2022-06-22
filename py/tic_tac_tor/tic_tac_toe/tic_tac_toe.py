import os
import json
import time

def main():

    try:
        f = open("config.json", "rt")
        config = dict(json.load(f))

        player1 = config["player1"]
        player2 = config["player2"]
        blank = config["blank"]
        columns = config["columns"]
        rows = config["rows"]
        required = config["required"]

        errMsg = "Somethong went wrong!\nPlease check the config file at \"{}\"!".format(os.getcwd() + "\\" + f.name)
    
        if int(config["columns"]) < int(config["required"]) or int(config["rows"]) < int(config["required"]):
            quit(print(errMsg))
        elif len(config["blank"]) > 1:
            quit(print(errMsg))

    except Exception as err:
        print(str(err) + "\nYou can still play the game with automatic settings")
        player1 = "X"
        player2 = "O"
        blank = "-"
        columns = 3
        rows = 3
        required = 3

    board = {}
    for i in range(1, columns + 1):
        for j in range(1, rows + 1):
            board.update({"{column}-{row}".format(column=str(i), row=str(j)):blank})

    def turn(player, column, row):
        board.update({"{column}-{row}".format(column=str(column), row=str(row)):str(player)})

    def check(player):
        checkerList = tuple()
        boardKeys = list(board.keys())
        for checker in boardKeys:
            if board[checker] == player:
                checkerList = list(checkerList)
                checkerList.append(checker)
        return checkerList, player

    def checkWin(list, player, column, row, required):
        checkerList = tuple(list)
        for checkSpot in checkerList:
            column, row = checkSpot.split("-")
            column = int(column)
            row = int(row)
            counter = 0
            for i in range(1, required, 1):
                if "{}-{}".format(column + i, row + i) in checkerList:
                    counter += 1
                    if counter == required-1:
                        print("{player} is the winner".format(player=player))
                        time.sleep(10)
                        quit()
            counter = 0
            for i in range(1, required, 1):
                if "{}-{}".format(column + i, row) in checkerList:
                    counter += 1
                    if counter == required-1:
                        print("{player} is the winner".format(player=player))
                        time.sleep(10)
                        quit()
            counter = 0
            for i in range(1, required, 1):
                if "{}-{}".format(column, row + i) in checkerList:
                    counter += 1
                    if counter == required - 1:
                        print("{player} is the winner".format(player=player))
                        time.sleep(10)
                        quit()
            counter = 0
            for i in range(1, required, 1):
                if "{}-{}".format(column - i, row + i) in checkerList:
                    counter += 1
                    if counter == required - 1:
                        print("{player} is the winner".format(player=player))
                        time.sleep(10)
                        quit()
            counter = 0


    for playerTurn in range(0, rows * columns):
        if playerTurn % 2 == 0:
            player = player1
        elif playerTurn % 2 == 1:
            player = player2
        canContinue = False
        while canContinue == False:
            try:
                column, row = input("Choose a spot on the board: (column 1-{columnMax}, row 1-{rowMax}) ({player}) ".format(columnMax=columns, rowMax=rows, player=player)).split(",")
                if board["{column}-{row}".format(column=str(column), row=str(row))] == blank:
                    turn(player=player, column=column, row=row)
                    canContinue = True
                else:
                    print("This block is not empty! ")
            except Exception as err:
                print("{}\nSomething went wrong".format(err))
        
        for row in range(1, rows + 1):
            for column in range(1, columns + 1):
                if column == rows:
                    endpoint = "\n"
                else:
                    endpoint = ""
                print(board["{column}-{row}".format(column=str(column), row=str(row))], end=endpoint)
        
        checkLister, checkPlayer = check(player)
        if len(checkLister) >= required:
            checkWin(checkLister, checkPlayer, column, row, required)

main()