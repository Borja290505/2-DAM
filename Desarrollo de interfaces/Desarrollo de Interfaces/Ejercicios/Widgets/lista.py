from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox, QComboBox, QListWidget, QAbstractItemView

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        lista = QListWidget()
        lista.addItems(["Uno", "Dos", "Tres"])
        lista.addItem("Cuatro")

        lista.currentTextChanged.connect(self.muestratexto)
        lista.currentTextChanged.connect(self.muestraindex)

        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection) # Para habilitar la multiselección

        self.setCentralWidget(lista)



    def muestraindex(self, s):
        print(s) # 0


    def muestratexto(self, s):
        print(s) # Uno
    

    
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant