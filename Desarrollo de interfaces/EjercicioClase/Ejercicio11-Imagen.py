from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel, QWidget
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        label = QLabel()
        label.setPixmap(QPixmap("img/toro.jpg"))

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(label)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()