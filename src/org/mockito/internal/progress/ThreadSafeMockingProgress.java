/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.progress;



@SuppressWarnings("unchecked")
public class ThreadSafeMockingProgress implements MockingProgress {
    
    private static ThreadLocal<MockingProgress> mockingProgress = new ThreadLocal<MockingProgress>();

    static MockingProgress threadSafely() {
        if (mockingProgress.get() == null) {
            mockingProgress.set(new MockingProgressImpl());
        }
        return mockingProgress.get();
    }
    
    public void reportStubbable(OngoingStubbing ongoingStubbing) {
        threadSafely().reportStubbable(ongoingStubbing);
    }

    public OngoingStubbing pullStubbable() {
        return threadSafely().pullStubbable();
    }
    
    public void verificationStarted(VerificationMode verify) {
        threadSafely().verificationStarted(verify);
    }

    public VerificationModeImpl pullVerificationMode() {
        return threadSafely().pullVerificationMode();
    }

    public int nextSequenceNumber() {
        return threadSafely().nextSequenceNumber();
    }

    public void stubbingStarted() {
        threadSafely().stubbingStarted();
    }

    public void validateState() {
        threadSafely().validateState();
    }

    public void stubbingCompleted() {
        threadSafely().stubbingCompleted();
    }
    
    public String toString() {
        return threadSafely().toString();
    }

    public void reset() {
        threadSafely().reset();
    }
}
