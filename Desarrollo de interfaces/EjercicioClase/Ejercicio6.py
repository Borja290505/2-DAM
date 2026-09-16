from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.num = 0
        self.setWindowTitle("Mi Aplicacion")

        self.boton = QPushButton("Pulsa")

        self.boton.setCheckable(True)
        self.boton.setChecked(True)
        self.boton.clicked.connect(self.botonPulsadoySoltado)

        self.setCentralWidget(self.boton)
    

    def botonPulsadoySoltado(self):
        self.num+=1
        print(self.boton.isChecked())

app = QApplication([])

window = MainWindow()

window.show()

app.exec()