from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        self.boton = QPushButton("Pulsa")

        self.boton.clicked.connect(self.botonPulsadoySoltado)

        self.setCentralWidget(self.boton)
    

    def botonPulsadoySoltado(self):
        self.boton.setText("Boton ya pulsado")
        self.boton.setEnabled(False)

    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()