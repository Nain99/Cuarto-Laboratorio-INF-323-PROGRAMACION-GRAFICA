package com.example.laboratorio4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author Nain_Perez
 * @version 25/06/2020 v1
 */

public class Rio {

    /* Las coordenadas bloque de agua*/
    private float vertices[] = new float[] {
            // Frente
            -1, -1, 1,  // 4 0
             1, -1, 1,  // 5 1
             1,  1, 1,  // 6 2
            -1,  1, 1,  // 7 3
            // Atrás
            -1,  1, -1, // 3 4
             1,  1, -1, // 2 5
             1, -1, -1, // 1 6
            -1, -1, -1, // 0 7
            // Izquierda
            -1, -1, -1, // 0 8
            -1, -1,  1, // 4 9
            -1,  1,  1, // 7 10
            -1,  1, -1, // 3 11
            // Derecha
            1, -1,  1,  // 5 12
            1, -1, -1,  // 1 13
            1,  1, -1,  // 2 14
            1,  1,  1,  // 6 15
            // Abajo
            -1, -1, -1, // 0 16
             1, -1, -1, // 1 17
             1, -1,  1, // 5 18
            -1, -1,  1, // 4 19
            // Arriba
            -1, 1,  1,  // 7 20
             1, 1,  1,  // 6 21
             1, 1, -1,  // 2 22
            -1, 1, -1   // 3 23
    };
    /* Los colores*/
    byte maxColor = (byte)255;
    private byte colores[] = new byte[] {
            // Frente
            (byte)(4), (byte) (130), maxColor, maxColor, // 4 0
            (byte)(4), (byte) (130), maxColor, maxColor, // 5 1
            (byte)(4), (byte) (130), maxColor, maxColor, // 6 2
            (byte)(4), (byte) (130), maxColor, maxColor, // 7 3
            // Atrás
            (byte)(4), (byte) (130), maxColor, maxColor, // 3 4
            (byte)(4), (byte) (130), maxColor, maxColor, // 2 5
            (byte)(4), (byte) (130), maxColor, maxColor, // 1 6
            (byte)(4), (byte) (130), maxColor, maxColor, // 0 7
            // Izquierda
            (byte)(4), (byte) (130), maxColor, maxColor, // 0 8
            (byte)(4), (byte) (130), maxColor, maxColor, // 4 9
            (byte)(4), (byte) (130), maxColor, maxColor, // 7 10
            (byte)(4), (byte) (130), maxColor, maxColor, // 3 11
            // Derecha
            (byte)(4), (byte) (130), maxColor, maxColor, // 5 12
            (byte)(4), (byte) (130), maxColor, maxColor, // 1 13
            (byte)(4), (byte) (130), maxColor, maxColor, // 2 14
            (byte)(4), (byte) (130), maxColor, maxColor, // 6 15
             // Abajo
            (byte)(4), (byte) (130), maxColor, maxColor, // 0 16
            (byte)(4), (byte) (130), maxColor, maxColor, // 1 17
            (byte)(4), (byte) (130), maxColor, maxColor, // 5 18
            (byte)(4), (byte) (130), maxColor, maxColor, // 4 19
            // Arriba
            (byte)(4), (byte) (130), maxColor, maxColor, // 7 20
            (byte)(4), (byte) (130), maxColor, maxColor, // 6 21
            (byte)(4), (byte) (130), maxColor, maxColor, // 2 22
            (byte)(4), (byte) (130), maxColor, maxColor // 3 23
    };
    /* Indices */
    private short indices[] = new short [] {
            0, 1, 2, 0, 2, 3,       // Frente
            4, 5, 6, 4, 6, 7,       // Atrás
            8, 9, 10, 8, 10, 11,    // Izquierda
            12, 13, 14, 12, 14, 15, // Derecha
            16, 17, 18, 16, 18, 19, // Abajo
            20, 21, 22, 20, 22, 23  // Arriba
    };
    private FloatBuffer bufVertices;
    private ByteBuffer bufColores;
    private ShortBuffer bufIndices;

    public Rio() {
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();
        bufVertices.put(vertices);
        bufVertices.rewind();
        /* Lee los colores */
        bufColores = ByteBuffer.allocateDirect(colores.length);
        bufColores.put(colores);
        bufColores.position(0);
        /* Lee los indices */
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder());
        bufIndices = bufByte.asShortBuffer();
        bufIndices.put(indices);
        bufIndices.rewind();
    }

    public void dibuja(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColorPointer(4, GL10.GL_UNSIGNED_BYTE, 0, bufColores);

        /* Se dibuja el bloque de agua */
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f,-0.9f,0);
        gl.glRotatef(90,0,1,0);
        gl.glScalef(1,0.05f,0.5f);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}

