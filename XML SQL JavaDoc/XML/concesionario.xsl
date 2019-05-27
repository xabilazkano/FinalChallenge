<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html>
  <head>
    <title>Concesionario</title>
  </head>
  <body>
    <center>
      <h1><u>Coches</u></h1>
      <table border="1">
      <tr>
        <td>Id serie</td>
        <td>Matricula</td>
        <td>Numero de bastidor</td>
        <td>Color</td>
        <td>Numero de Asientos</td>
        <td>Precio</td>
        <td>Marca</td>
        <td>Modelo</td>
        <td>Fecha de fabricación</td>
        <td>Número de puertas</td>
        <td>Capacidad maletero</td>
    </tr>
		 <xsl:for-each select="vehiculos/coches/coche">
     <tr>
        <td><xsl:value-of select="id_serie" /></td>
        <td><xsl:value-of select="matricula" /></td>
        <td><xsl:value-of select="numero_bastidor" /></td>
        <td><xsl:value-of select="color" /></td>
       <td><xsl:value-of select="numero_asientos" /></td>
        <td><xsl:value-of select="precio" /></td>
        <td><xsl:value-of select="marca" /></td>
        <td><xsl:value-of select="modelo" /></td>
          <td><xsl:value-of select="fecha_fabricacion" /></td>
        <td><xsl:value-of select="numero_puertas" /></td>
        <td><xsl:value-of select="capacidad_maletero" /></td>
      </tr>
      </xsl:for-each>
    </table>
          <h1><u>Camiones</u></h1>
      <table border="1">
      <tr>
        <td>Id serie</td>
        <td>Matricula</td>
        <td>Numero de bastidor</td>
        <td>Color</td>
        <td>Numero de Asientos</td>
        <td>Precio</td>
        <td>Marca</td>
        <td>Modelo</td>
        <td>Fecha de fabricación</td>
        <td>Carga</td>
        <td>Tipo de mercancia</td>
    </tr>
		 <xsl:for-each select="vehiculos/camiones/camion">
     <tr>
        <td><xsl:value-of select="id_serie" /></td>
        <td><xsl:value-of select="matricula" /></td>
        <td><xsl:value-of select="numero_bastidor" /></td>
        <td><xsl:value-of select="color" /></td>
       <td><xsl:value-of select="numero_asientos" /></td>
        <td><xsl:value-of select="precio" /></td>
        <td><xsl:value-of select="marca" /></td>
        <td><xsl:value-of select="modelo" /></td>
          <td><xsl:value-of select="fecha_fabricacion" /></td>
        <td><xsl:value-of select="carga" /></td>
        <td><xsl:value-of select="tipo_mercancia" /></td>
      </tr>
      </xsl:for-each>
    </table>
    </center>
  </body>
</html>
  </xsl:template>
</xsl:stylesheet>
