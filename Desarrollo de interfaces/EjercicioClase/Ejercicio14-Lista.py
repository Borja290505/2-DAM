from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QListWidget, QMainWindow, QAbstractItemView

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        lista = QListWidget()
        lista.addItems(["Uno","Dos","Tres","Cuatro"])
        lista.currentTextChanged.connect(self.muestraTexto)
        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(lista)

    def muestraTexto(self,texto):
        print(texto)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()