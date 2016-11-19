package com.mycompany.portlet;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("sample-springmvc-portlet")
@RequestMapping("view")
public class SampleSpringController {

    @RenderMapping
    public ModelAndView handleRenderRequest(RenderRequest request, RenderResponse response) {

        User user = null;
        String firstName = "anonymous";
        try {
            user = PortalUtil.getUser(request);
            if (user != null) {
                firstName = user.getFirstName();
            }

        } catch (PortalException e) {
            // user not found
        }

        ModelAndView model = new ModelAndView("view");
        model.addObject("firstName", firstName);
        return model;
    }
}
