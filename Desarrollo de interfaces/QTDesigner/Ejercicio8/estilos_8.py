import os
import sys
from Ejercicio8 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication

# Fuerza a Python a trabajar dentro de la carpeta donde está este script (Ejercicio8)
os.chdir(os.path.dirname(os.path.abspath(__file__)))

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.comboBox.currentIndexChanged.connect(self.cambiarEstilo)
        self.cambiarEstilo()
        self.show()

    def cambiarEstilo(self):
        # Ahora las 3 rutas son relativas a la carpeta Ejercicio8
        estilos = [
            "Estilos/estilo1.qss",
            "Estilos/estilo2.qss",
            "Estilos/estilo3.qss"
        ]
        with open(estilos[self.comboBox.currentIndex()], "r") as f:
            app.setStyleSheet(f.read())
    
app = QApplication([])
ventana = MainWindow()
app.exec()
