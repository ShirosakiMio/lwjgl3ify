/*
 * Copyright (c) 2002-2010 LWJGL Project All rights reserved. Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following conditions are met: * Redistributions of source code
 * must retain the above copyright notice, this list of conditions and the following disclaimer. * Redistributions in
 * binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution. * Neither the name of 'LWJGL' nor the names of
 * its contributors may be used to endorse or promote products derived from this software without specific prior written
 * permission. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjglx;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import javax.annotation.Nullable;

public class PointerBuffer extends org.lwjgl.PointerBuffer {

    private static final Field containerAccess;

    static {
        Class<org.lwjgl.PointerBuffer> pbClass = org.lwjgl.PointerBuffer.class;
        try {
            containerAccess = pbClass.getDeclaredField("container");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private static ByteBuffer getContainer(org.lwjgl.PointerBuffer buffer) {
        try {
            return (ByteBuffer) containerAccess.get(buffer);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    protected PointerBuffer(long address, @Nullable ByteBuffer container, int mark, int position, int limit,
        int capacity) {
        super(address, container, mark, position, limit, capacity);
    }

    protected PointerBuffer(org.lwjgl.PointerBuffer ver3) {
        super(ver3.address(), getContainer(ver3), ver3.position(), ver3.position(), ver3.limit(), ver3.capacity());
    }

    public PointerBuffer(ByteBuffer buffer) {
        this(
            org.lwjgl.system.MemoryUtil.memAddress(buffer),
            buffer,
            0,
            buffer.position(),
            buffer.limit(),
            buffer.capacity());
    }

    /**
     * Allocates a new pointer buffer.
     *
     * <p>
     * The new buffer's position will be zero, its limit will be its capacity, and its mark will be undefined.
     * </p>
     *
     * @param capacity the new buffer's capacity, in pointers
     *
     * @return the new pointer buffer
     *
     * @throws IllegalArgumentException If the {@code capacity} is a negative integer
     */
    public static PointerBuffer allocateDirect(int capacity) {
        return new PointerBuffer(org.lwjgl.PointerBuffer.allocateDirect(capacity));
    }

    /**
     * Creates a new PointerBuffer that starts at the specified memory address and has the specified capacity.
     *
     * @param address  the starting memory address
     * @param capacity the buffer capacity, in number of pointers
     */
    public static PointerBuffer create(long address, int capacity) {
        return new PointerBuffer(org.lwjgl.PointerBuffer.create(address, capacity));
    }

    /**
     * Creates a new PointerBuffer using the specified ByteBuffer as its pointer data source.
     *
     * @param source the source buffer
     */
    public static PointerBuffer create(ByteBuffer source) {
        return new PointerBuffer(org.lwjgl.PointerBuffer.create(source));
    }

    public static int getPointerSize() {
        return org.lwjgl.PointerBuffer.POINTER_SIZE;
    }
}
