/*******************************************************************************
 * (c) Copyright 2017 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *******************************************************************************/
package io.cloudslang.web.helper;

import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileHelper {

    private static String contentPath;

    public static String filePathToFlowId(String filePath) {
        return filePath
            .substring(0, filePath.indexOf("."))
            .replace(contentPath + File.separator, "")
            .replace(File.separator, ".");
    }

    public static String filePathToFlowName(String filePath) {
        return filePath.substring(0, filePath.lastIndexOf(".sl"));
    }

    public static String flowIdToFilePath(String flowId) {
        flowId = contentPath + File.separator + flowId.replace(".", File.separator).concat(".sl");
        return flowId;
    }

    public static String getContentPath() {
        return contentPath;
    }

    @Value("${content.path}")
    public void setContentPath(String contentPath) {
        this.contentPath = Paths.get(contentPath).normalize().toString();
    }

}
