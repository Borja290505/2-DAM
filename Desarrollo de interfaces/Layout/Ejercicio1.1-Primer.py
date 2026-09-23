from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QListWidget, QMainWindow, QCalendarWidget,QHBoxLayout, QWidget
from Cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        plantilla=QHBoxLayout()

        plantilla.addWidget(Color("red"))
        plantilla.addWidget(Color("yellow"))
        plantilla.addWidget(Color("blue"))
        plantilla.addWidget(Color("grey"))
        plantilla.addWidget(Color("green"))

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()