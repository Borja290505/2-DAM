from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QListWidget, QMainWindow, QLineEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        self.texto = QLineEdit()
        self.texto.setMaxLength(10)
        self.texto.setPlaceholderText("Introduce tu nombre...")
        #texto.textChanged.connect(self.textoCambiado)
        self.texto.returnPressed.connect(self.introPulsado)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(self.texto)

    def introPulsado(self):
        print(self.texto.text())
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()