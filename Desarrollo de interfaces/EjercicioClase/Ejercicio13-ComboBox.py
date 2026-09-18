from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QComboBox

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        lista = QComboBox()
        lista.addItems(["Uno","Dos","Tres","Cuatro"])
        lista.setEditable(True)


        lista.currentIndexChanged.connect(self.muestraIndice)
        lista.currentTextChanged.connect(self.muestraTexto)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(lista)

    def muestraIndice(self,indice):
        print(indice)

    def muestraTexto(self,texto):
        print(texto)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()