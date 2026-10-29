from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcio 
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiAplicacion")

        label = QLabel("Hola")
        formato = label.font()
        formato.setPointSize(99)
        formato.setFamily("Arial")
        formato.setBold(True)
        label.setFont(formato)
        label.setAlignment(Qt.AlignmentFlag.AlignVCenter | Qt.AlignmentFlag.AlignHCenter) # Alineacion Horizontal y vertical importante si pones mas de 1 separarlo por tuberias
        
        
        self.setCentralWidget(label)

    
            
             
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant