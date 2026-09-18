from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QCheckBox

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        casilla = QCheckBox("Casilla de verificacion")
        formato = casilla.font()
        formato.setBold(True)
        casilla.setFont(formato)

        casilla.stateChanged.connect(self.muestraEstado)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(casilla)

    def muestraEstado(self,s):
        print(s)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()