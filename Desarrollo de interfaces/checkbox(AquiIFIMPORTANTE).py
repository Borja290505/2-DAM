from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget, QCheckBox

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        casilla = QCheckBox("Casilla de verificacion")
        formato = casilla.font()
        formato.setBold(True)
        formato.setPointSize(8)
        casilla.setFont(formato)

        casilla.stateChanged.connect(self.muestraestado)

        self.setCentralWidget(casilla)

    def muestraestado(self, s):
        print(["Desmarcado", "", "Marcado"][s]) # 0 es no marcado, 1 es parcialmente marcado (CASI NUNCA VAMOS A VER ESTO EN EL MUNDO REAL), 2 es marcado
       
        
    

    
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant