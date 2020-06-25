package com.example.laboratorio4;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;

/**
 * @author Nain_Perez
 * @version 25/06/2020 v1
 */

public class Renderiza extends GLSurfaceView implements Renderer {
    private Cesped cesped;
    private Rio rio;
    private Sol sol;

    private float antX;
    private float angulo;
    private Arbol arbol;

    public Renderiza(Context contexto) {
        super(contexto);
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
        cesped = new Cesped();
        rio = new Rio();
        sol = new Sol(1,50,50);
        angulo = 0;
        arbol = new Arbol(1, 15, 15);
        gl.glShadeModel(GL10.GL_FLAT);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glClearColor(193f/255f, 255f/255f, 255f/255f, 1);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glLineWidth(4f);
        gl.glRotatef(angulo,0,1,0);
        gl.glPushMatrix();
        gl.glTranslatef(2,3,1);
        sol.dibuja(gl);
        gl.glPopMatrix();

        /*RENDERIZA ARBOLES MIVEL 0*/
        /*ARBOL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0,0.35f);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.35f,0.2f);
        gl.glColor4f(0,1,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*ARBOL 2*/
        gl.glPushMatrix();
        gl.glTranslatef(1,0,0);
        gl.glRotatef(45,0,1,0);
        gl.glScalef(0.17f,0.35f,0.17f);
        gl.glColor4f(0,100f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*ARBOL 3*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-0.5f);
        gl.glTranslatef(1.7f,0,0);
        gl.glRotatef(45,0,1,0);
        gl.glScalef(0.17f,0.35f,0.17f);
        gl.glColor4f(0,64f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();

        /*REDERIZA CESPED NIVEL 0*/
        gl.glPushMatrix();
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.1f,0);
        gl.glScalef(1,1,1.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 2*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.2f,0);
        gl.glScalef(1,1,2);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 3*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.3f,0);
        gl.glScalef(1,1,2.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 4*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.4f,0);
        gl.glScalef(1,1,3f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 5*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.5f,0);
        gl.glScalef(1,1,3.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 6*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.6f,0);
        gl.glScalef(1,1,4f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 7*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.7f,0);
        gl.glScalef(1,1,4.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 8*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.8f,0);
        gl.glScalef(1,1,5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 9*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.9f,0);
        gl.glScalef(1,1,5.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 10*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1f,0);
        gl.glScalef(1,1,6f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 11*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.1f,0);
        gl.glScalef(1,1,6.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 12*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.2f,0);
        gl.glScalef(1,1,7f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 13*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.3f,0);
        gl.glScalef(1,1,7.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 14*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.4f,0);
        gl.glScalef(1,1,8f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 15*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.5f,0);
        gl.glScalef(1,1,8.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 16*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.6f,0);
        gl.glScalef(1,1,9f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 17*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.7f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 18*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.8f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 19*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.9f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 20*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 21*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.1f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 22*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.2f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 23*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.3f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();
        /*REDERIZA CESPED NIVEL 24*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.4f,0);
        gl.glScalef(1,1,9.5f);
        cesped.dibuja(gl);
        gl.glPopMatrix();


        /*RENDERIZA RIO NIVEL 0*/
        gl.glPushMatrix();
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.1f,0);
        gl.glScalef(1,1,1.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 2*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.2f,0);
        gl.glScalef(1,1,2f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 3*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.3f,0);
        gl.glScalef(1,1,2.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 4*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.4f,0);
        gl.glScalef(1,1,3f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 5*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.5f,0);
        gl.glScalef(1,1,3.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 6*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.6f,0);
        gl.glScalef(1,1,4f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 7*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.7f,0);
        gl.glScalef(1,1,4.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 8*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.8f,0);
        gl.glScalef(1,1,5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 9*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-0.9f,0);
        gl.glScalef(1,1,5.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 10*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1f,0);
        gl.glScalef(1,1,6f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 11*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.1f,0);
        gl.glScalef(1,1,6.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 12*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.2f,0);
        gl.glScalef(1,1,7f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 13*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.3f,0);
        gl.glScalef(1,1,7.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 14*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.4f,0);
        gl.glScalef(1,1,8f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 15*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.5f,0);
        gl.glScalef(1,1,8.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 16*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.6f,0);
        gl.glScalef(1,1,9f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 17*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.7f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 18*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.8f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 19*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-1.9f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 20*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 21*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.1f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 22*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.2f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 23*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.3f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA RIO NIVEL 24*/
        gl.glPushMatrix();
        gl.glTranslatef(0,-2.4f,0);
        gl.glScalef(1,1,9.5f);
        rio.dibuja(gl);
        gl.glPopMatrix();


        /*RENDERIZA ARBOLES NIVEL 1*/
        /*ARBOL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0f,1.2f);
        gl.glTranslatef(0,-0.1f,0);
        gl.glTranslatef(-0.5f,0,0);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.3f,0.2f);
        gl.glColor4f(0,200f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*ARBOL 2*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0f,1.35f);
        gl.glTranslatef(0,-0.1f,0);
        gl.glTranslatef(1.5f,0,0);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.3f,0.2f);
        gl.glColor4f(0,160f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA ARBOL NIVEL 2*/
        /*ARBOL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0f,1.8f);
        gl.glTranslatef(0,-0.2f,0);
        gl.glTranslatef(0.7f,0,0);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.3f,0.2f);
        gl.glColor4f(0,230f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();

        /*RENDERIZA ARBOLES NIVEL 0 ATRAS*/
        /*ARBOL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-0.5f);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.35f,0.2f);
        gl.glColor4f(0,100f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*ARBOL 2*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0,-0.8f);
        gl.glTranslatef(1,0,0);
        gl.glRotatef(45,0,1,0);
        gl.glScalef(0.17f,0.35f,0.17f);
        gl.glColor4f(0,150f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA ARBOLES ATRAS NIVEL 1*/
        /*ARBOL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0f,-1.2f);
        gl.glTranslatef(0,-0.1f,0);
        gl.glTranslatef(-0.8f,0,0);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.3f,0.2f);
        gl.glColor4f(0,200f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*ARBOL 2*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0f,-1.35f);
        gl.glTranslatef(0,-0.1f,0);
        gl.glTranslatef(0.5f,0,0);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.3f,0.2f);
        gl.glColor4f(0,160f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        /*RENDERIZA ARBOL ATRAS NIVEL 2*/
        /*ARBOL 1*/
        gl.glPushMatrix();
        gl.glTranslatef(0,0f,-1.8f);
        gl.glTranslatef(0,-0.2f,0);
        gl.glTranslatef(1.5f,0,0);
        gl.glRotatef(25,0,1,0);
        gl.glScalef(0.2f,0.3f,0.2f);
        gl.glColor4f(0,230f/255f,0,1);
        arbol.dibuja(gl);
        gl.glPopMatrix();
        gl.glFlush();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        if (w <= h)
            gl.glOrthof(-2, 2, -2 * (float) h / (float) w, 2 * (float) h
                    / (float) w, -10, 10);
        else
            gl.glOrthof(-2 * (float) w / (float) h, 2 * (float) w / (float) h,
                    -2, 2, -10, 10);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - antX;
                angulo = dx*0.28125f;
                requestRender();
        }
        antX = x;
        return true;
    }
}
