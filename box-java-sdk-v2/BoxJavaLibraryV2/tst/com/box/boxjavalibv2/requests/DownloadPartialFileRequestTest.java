package com.box.boxjavalibv2.requests;

import junit.framework.Assert;

import org.apache.http.HttpStatus;
import org.junit.Test;

import com.box.boxjavalibv2.exceptions.AuthFatalFailureException;
import com.box.boxjavalibv2.testutils.TestUtils;
import com.box.restclientv2.RestMethod;
import com.box.restclientv2.exceptions.BoxRestException;

public class DownloadPartialFileRequestTest extends DownloadFileRequestTest {

    @Override
    @Test
    public void testUri() {
        Assert.assertEquals("/files/123/content", DownloadPartialFileRequest.getUri("123"));
    }

    @Override
    @Test
    public void testRequestIsWellFormed() throws BoxRestException, AuthFatalFailureException {
        String id = "testid123";

        DownloadPartialFileRequest request = new DownloadPartialFileRequest(CONFIG, JSON_PARSER, id, null);
        testRequestIsWellFormed(request, TestUtils.getConfig().getApiUrlAuthority(),
            TestUtils.getConfig().getApiUrlPath().concat(DownloadPartialFileRequest.getUri(id)), HttpStatus.SC_PARTIAL_CONTENT, RestMethod.GET);

    }
}
