from PyQt6.QtWidgets import (QApplication, QMainWindow, QWidget, QStackedWidget, QVBoxLayout, QHBoxLayout,
                             QLabel, QLineEdit, QComboBox, QPushButton, QRadioButton, QMessageBox,
                             QToolBar, QStatusBar)
from PyQt6.QtGui import QAction, QActionGroup
from PyQt6.QtCore import Qt


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Repaso PyQt6")
        self.setMinimumSize(500, 400)

        # <=========== Páginas apiladas ===========>
        # QStackedWidget: como un mazo de cartas, solo se ve la de arriba
        self.stack = QStackedWidget()
        self.stack.addWidget(self.crear_formulario())   # página 0
        self.stack.addWidget(self.crear_calculadora())  # página 1
        self.stack.addWidget(self.crear_comunidad())    # página 2
        self.setCentralWidget(self.stack)

        # <=========== Acciones ===========>
        # Una QAction es "algo que se puede hacer". La misma acción
        # se puede poner en el menú y en la toolbar a la vez.
        self.accion_formulario = QAction("Formulario", self)
        self.accion_formulario.setStatusTip("Abre el formulario de datos")
        self.accion_formulario.setCheckable(True)
        self.accion_formulario.triggered.connect(lambda: self.cambiar_pagina(0, "Formulario"))

        self.accion_calculadora = QAction("Calculadora", self)
        self.accion_calculadora.setStatusTip("Abre la calculadora de sumas")
        self.accion_calculadora.setCheckable(True)
        self.accion_calculadora.triggered.connect(lambda: self.cambiar_pagina(1, "Calculadora"))

        self.accion_comunidad = QAction("Comunidad", self)
        self.accion_comunidad.setStatusTip("Abre el selector de comunidad y provincia")
        self.accion_comunidad.setCheckable(True)
        self.accion_comunidad.triggered.connect(lambda: self.cambiar_pagina(2, "Comunidad"))

        # QActionGroup hace que solo una de las tres esté marcada a la vez
        grupo = QActionGroup(self)
        grupo.addAction(self.accion_formulario)
        grupo.addAction(self.accion_calculadora)
        grupo.addAction(self.accion_comunidad)
        self.accion_formulario.setChecked(True)

        accion_reiniciar = QAction("Reiniciar", self)
        accion_reiniciar.setStatusTip("Deja el ejercicio actual como al principio")
        accion_reiniciar.triggered.connect(self.reiniciar)

        accion_salir = QAction("Salir", self)
        accion_salir.setShortcut("Ctrl+Q")
        accion_salir.setStatusTip("Cierra la aplicación")
        accion_salir.triggered.connect(self.salir)

        # <=========== Menú ===========>
        menu = self.menuBar()

        menu_archivo = menu.addMenu("Archivo")
        menu_archivo.addAction(accion_reiniciar)
        menu_archivo.addSeparator()
        menu_archivo.addAction(accion_salir)

        menu_ejercicios = menu.addMenu("Ejercicios")
        menu_ejercicios.addAction(self.accion_formulario)
        menu_ejercicios.addAction(self.accion_calculadora)
        menu_ejercicios.addSeparator()
        menu_ejercicios.addAction(self.accion_comunidad)

        # <=========== Toolbar ===========>
        toolbar = QToolBar("Ejercicios")
        self.addToolBar(toolbar)
        toolbar.addAction(self.accion_formulario)   # los MISMOS objetos que en el menú
        toolbar.addAction(self.accion_calculadora)
        toolbar.addAction(self.accion_comunidad)

        # <=========== Barra de estado ===========>
        self.setStatusBar(QStatusBar(self))

    # =====================================================
    #  Construcción de las páginas
    # =====================================================

    def crear_formulario(self):
        nombreHL = QHBoxLayout()
        self.nombre_lineEdit = QLineEdit()
        nombreHL.addWidget(QLabel("Nombre: "))
        nombreHL.addWidget(self.nombre_lineEdit)

        apellidosHL = QHBoxLayout()
        self.apellidos_lineEdit = QLineEdit()
        apellidosHL.addWidget(QLabel("Apellidos: "))
        apellidosHL.addWidget(self.apellidos_lineEdit)

        departamentoHL = QHBoxLayout()
        self.departamento_comboBox = QComboBox()
        self.departamento_comboBox.addItems(["Contabilidad", "Ventas", "Reparto"])
        departamentoHL.addWidget(QLabel("Departamento: "))
        departamentoHL.addWidget(self.departamento_comboBox)

        botonEnviar = QPushButton("Enviar")
        botonEnviar.clicked.connect(self.enviar)

        layoutV = QVBoxLayout()
        layoutV.addLayout(nombreHL)
        layoutV.addLayout(apellidosHL)
        layoutV.addLayout(departamentoHL)
        layoutV.addWidget(botonEnviar)
        layoutV.addStretch()  # empuja todo hacia arriba

        pagina = QWidget()
        pagina.setLayout(layoutV)
        return pagina

    def crear_calculadora(self):
        self.acum = 0

        self.campo = QLabel()
        self.campo.setAlignment(Qt.AlignmentFlag.AlignRight)

        layoutH1 = QHBoxLayout()
        layoutH2 = QHBoxLayout()
        layoutH3 = QHBoxLayout()
        layoutH4 = QHBoxLayout()
        layoutH5 = QHBoxLayout()

        botonSuma = QPushButton("+")
        botonSuma.clicked.connect(self.sumar)
        layoutH4.addWidget(botonSuma)

        for i in range(0, 10):
            boton = QPushButton(str(i))
            boton.clicked.connect(self.escribir_numero)
            if i >= 7:
                layoutH1.addWidget(boton)
            elif i >= 4:
                layoutH2.addWidget(boton)
            elif i >= 1:
                layoutH3.addWidget(boton)
            else:
                layoutH4.addWidget(boton)

        botonIgual = QPushButton("=")
        botonIgual.clicked.connect(self.igual)
        layoutH4.addWidget(botonIgual)

        botonCE = QPushButton("CE")
        botonCE.clicked.connect(self.ce)
        layoutH5.addWidget(botonCE)

        layoutV = QVBoxLayout()
        layoutV.addWidget(self.campo)
        layoutV.addLayout(layoutH1)
        layoutV.addLayout(layoutH2)
        layoutV.addLayout(layoutH3)
        layoutV.addLayout(layoutH4)
        layoutV.addLayout(layoutH5)

        pagina = QWidget()
        pagina.setLayout(layoutV)
        return pagina

    def crear_comunidad(self):
        radiosHL = QHBoxLayout()
        self.aragon = QRadioButton("Aragón")
        self.cValenciana = QRadioButton("Comunidad Valenciana")
        radiosHL.addWidget(self.aragon)
        radiosHL.addWidget(self.cValenciana)

        # toggled avisa al marcar Y al desmarcar, por eso se pasa "marcado"
        self.aragon.toggled.connect(
            lambda marcado: self.cargar_provincias(["Huesca", "Zaragoza", "Teruel"]) if marcado else None)
        self.cValenciana.toggled.connect(
            lambda marcado: self.cargar_provincias(["Castellón", "Valencia", "Alicante"]) if marcado else None)

        provinciaHL = QHBoxLayout()
        self.provincia_comboBox = QComboBox()
        provinciaHL.addWidget(QLabel("Provincia: "))
        provinciaHL.addWidget(self.provincia_comboBox)

        layoutV = QVBoxLayout()
        layoutV.addLayout(radiosHL)
        layoutV.addLayout(provinciaHL)
        layoutV.addStretch()

        pagina = QWidget()
        pagina.setLayout(layoutV)
        return pagina

    # =====================================================
    #  Menú, toolbar y barra de estado
    # =====================================================

    def cambiar_pagina(self, indice, nombre):
        self.stack.setCurrentIndex(indice)
        self.statusBar().showMessage(f"Ejercicio actual: {nombre}", 3000)  # 3000 ms = 3 s

    def salir(self):
        respuesta = QMessageBox.question(self, "Salir", "¿Seguro que quieres salir?")
        if respuesta == QMessageBox.StandardButton.Yes:
            self.close()

    def reiniciar(self):
        pagina = self.stack.currentIndex()

        if pagina == 0:
            self.nombre_lineEdit.clear()
            self.apellidos_lineEdit.clear()
            self.departamento_comboBox.setCurrentIndex(0)
        elif pagina == 1:
            self.ce()
        elif pagina == 2:
            # Con radios exclusivos no se puede desmarcar sin más:
            # se quita la exclusividad, se desmarcan y se vuelve a poner
            for radio in (self.aragon, self.cValenciana):
                radio.setAutoExclusive(False)
                radio.setChecked(False)
                radio.setAutoExclusive(True)
            self.provincia_comboBox.clear()

        self.statusBar().showMessage("Ejercicio reiniciado", 3000)

    # =====================================================
    #  Lógica de cada ejercicio
    # =====================================================

    # ---- Formulario ----
    def enviar(self):
        nombre = self.nombre_lineEdit.text().strip()
        apellidos = self.apellidos_lineEdit.text().strip()

        if nombre == "" or apellidos == "":
            QMessageBox.warning(self, "Error", "Se deben rellenar los campos nombre y apellidos")
        else:
            QMessageBox.information(self, "Datos enviados",
                                    f"Nombre: {nombre}\n"
                                    f"Apellidos: {apellidos}\n"
                                    f"Departamento: {self.departamento_comboBox.currentText()}")

    # ---- Calculadora ----
    def escribir_numero(self):
        self.campo.setText(self.campo.text() + self.sender().text())

    def sumar(self):
        if self.campo.text() != "":
            self.acum += int(self.campo.text())
            self.campo.clear()

    def igual(self):
        if self.campo.text() != "":
            self.campo.setText(str(int(self.campo.text()) + self.acum))
            self.acum = 0

    def ce(self):
        self.campo.clear()
        self.acum = 0

    # ---- Comunidad ----
    def cargar_provincias(self, provincias):
        self.provincia_comboBox.clear()
        self.provincia_comboBox.addItems(provincias)


app = QApplication([])
window = MainWindow()
window.show()
app.exec()