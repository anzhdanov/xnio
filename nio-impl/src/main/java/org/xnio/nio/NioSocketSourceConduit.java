/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xnio.nio;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
final class NioSocketSourceConduit extends AbstractNioStreamSourceConduit<SocketChannel> {

    NioSocketSourceConduit(final AbstractNioStreamConnection connection, final SelectionKey selectionKey, final WorkerThread workerThread) {
        super(connection, selectionKey, workerThread);
    }

    protected void closeAction() throws IOException {
        try {
            getChannel().socket().shutdownInput();
        } catch (ClosedChannelException ignored) {}
    }
}