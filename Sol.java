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

public class Sol {

    int segmentosH;
    int segmentosV;
    private short indices[];
    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;

    public Sol(float radio, int segmentosH, int segmentosV){
        this.segmentosH = segmentosH;
        this.segmentosV = segmentosV;
        float[] vertices = new float[segmentosH * segmentosV * 4 * 3];
        float[] normales = new float[segmentosH * segmentosV * 4 * 3];
        indices = new short[segmentosH * segmentosV * 12];
        int i = 0;
        float inc_phi = 360f / segmentosH;
        // longitud
        for (float phi = 0; phi < 360; phi += inc_phi) {
            float sp = (float)Math.sin(Math.toRadians(phi));
            float cp = (float)Math.cos(Math.toRadians(phi));
            float sp1 = (float)Math.sin(Math.toRadians(phi + inc_phi));
            float cp1 = (float)Math.cos(Math.toRadians(phi + inc_phi));
            float inc_theta = 180f / segmentosV;
        // latitud
            for (float theta = 0; theta < 180; theta += inc_theta) {
                float st = (float)Math.sin(Math.toRadians(theta));
                float ct = (float)Math.cos(Math.toRadians(theta));
                float st1 = (float)Math.sin(Math.toRadians(theta + inc_theta));
                float ct1 = (float)Math.cos(Math.toRadians(theta + inc_theta));
                vertices[i ] = radio * st * sp;
                vertices[i + 1] = radio * ct;
                vertices[i + 2] = radio * st * cp;
                vertices[i + 3] = radio * st1 * sp;
                vertices[i + 4] = radio * ct1;
                vertices[i + 5] = radio * st1 * cp;
                vertices[i + 6] = radio * st1 * sp1;
                vertices[i + 7] = radio * ct1;
                vertices[i + 8] = radio * st1 * cp1;
                vertices[i + 9] = radio * st * sp1;
                vertices[i +10] = radio * ct;
                vertices[i +11] = radio * st * cp1;
                i = i + 12;
            }
        }
        /* Lee los vértices */
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();
        bufVertices.put(vertices).rewind();

        /* Lee las normales */
        bufByte = ByteBuffer.allocateDirect(normales.length * 4);
        bufByte.order(ByteOrder.nativeOrder());

        for (int k = 0, j = 0; k < segmentosH * segmentosV * 12; k += 12, j += 4) {
            indices[k ] = (short) j;
            indices[k + 1] = (short) (j + 1);
            indices[k + 2] = (short) (j + 1);
            indices[k + 3] = (short) (j + 2);
            indices[k + 4] = (short) (j + 2);
            indices[k + 5] = (short) j;
            indices[k + 6] = (short) j;
            indices[k + 7] = (short) (j + 2);
            indices[k + 8] = (short) (j + 2);
            indices[k + 9] = (short) (j + 3);
            indices[k + 10] = (short) (j + 3);
            indices[k + 11] = (short) j;
        }
        /* Lee los indices */
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder());
        bufIndices = bufByte.asShortBuffer();
        bufIndices.put(indices).rewind();

    }
    public void dibuja(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glPushMatrix();
        gl.glColor4f(1,1,0,1);
        gl.glDrawElements(GL10.GL_TRIANGLE_FAN, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glPopMatrix();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}