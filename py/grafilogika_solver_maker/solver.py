from converter import *

def main(path):

    converter = Convert(path)
    pixels = converter.getPixels()
    size = converter.getSize()
    blackPixels = converter.getBlackPixels()

    #  print(blackPixels)
    counter = 0
    row_nums = []
    step = 1

    for i in range(0, len(pixels), step):
        if i in blackPixels:
            if i % size[0] == size[0] - 1:  # if the pixel is the last in the row
                row_nums.append(counter + 1)
                row_nums.append("\n")
                counter = 0
            elif i + step in blackPixels:  # if the next pixel is black
                counter += 1
            elif i + step not in blackPixels:  # if the next pixel is white
                row_nums.append(counter + 1)
                counter = 0
        elif i not in blackPixels:
            if i % size[0] == size[0] - 1:
                row_nums.append("\n")

    column_nums = []
    step = size[1]
    current_column = 0
    minus = 0

    for j_check in range(0, len(pixels) * size[1], step):
        j = j_check + minus
        if j in blackPixels:
            if j != current_column and j % (len(pixels) - size[1]) == current_column:
                column_nums.append(counter + 1)
                column_nums.append("\n")
                current_column += 1
                minus -= (len(pixels) - 1)
                counter = 0
            elif j + step in blackPixels:  # if the next pixel is black
                counter += 1
            elif j + step not in blackPixels:  # if the next pixel is white
                column_nums.append(counter + 1)
                counter = 0
        elif j not in blackPixels:
            if j != current_column and j % (len(pixels) - size[1]) == current_column:
                column_nums.append("\n")
                current_column += 1
                minus -= (len(pixels) - 1)
                counter = 0

    print(row_nums)
    print(column_nums)

    return row_nums, column_nums


row, column = main("test_0.png")
row_numbers = ""


for i in row:
    row_numbers = row_numbers + str(i)

row_numbers = row_numbers.split("\n")

print(row_numbers)

row_max = max(row_numbers)

