from PIL import Image

class Convert:

    def __init__(self, path):
        self.path = path

        try:
            self.file = Image.open(path, "r")
        except Exception as e:
            quit(print(e))

        self.pixels = list(self.file.getdata())
        self.blackPixels = []
        for i in range(len(self.pixels)):
            if self.pixels[i] == (0, 0, 0):
                self.blackPixels.append(i)

    def getSize(self):
        x_size = list(self.file.getbbox())[2]
        y_size = list(self.file.getbbox())[3]
        return [x_size, y_size]

    def getPixels(self):
        return self.pixels

    def getFile(self):
        return self.file

    def getBlackPixels(self):
        return self.blackPixels
