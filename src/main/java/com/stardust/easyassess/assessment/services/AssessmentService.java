package com.stardust.easyassess.assessment.services;


import com.stardust.easyassess.assessment.models.Article;
import com.stardust.easyassess.assessment.models.Assessment;
import com.stardust.easyassess.assessment.models.Asset;
import com.stardust.easyassess.assessment.models.CertificationModel;
import com.stardust.easyassess.assessment.models.form.ActualValue;
import com.stardust.easyassess.assessment.models.form.Form;
import com.stardust.easyassess.assessment.models.form.Specimen;
import com.stardust.easyassess.core.query.Selection;
import jxl.write.WriteException;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface AssessmentService extends EntityService<Assessment> {
    void createAssessment(Assessment assessment);

    List<Assessment> findByParticipant(String participant);

    Form addParticipant(String assessmentId, String participant, String participantName);

    Form removeParticipant(String assessmentId, String participantId);

    Assessment reopenAssessment(String assessmentId);

    Specimen findSpecimen(String assessmentId, String group,  String specimenCode);

    Assessment finalizeAssessment(String id);

    void finalizeAssessment(Assessment assessment);

    void exportToExcel(Assessment assessment, OutputStream outputStream) throws IOException, WriteException;

    void generateAssessmentCertification(CertificationModel model, OutputStream outputStream) throws IOException;

    List<Article> getArticles(String id);

    void removeArticles(Assessment assessment);

    Article saveArticle(String id, Article article);

    Article removeArticle(String id, String articleId);

    List<Asset> getAssets(String id);

    Asset addAsset(String id, String title, MultipartFile asset) throws IOException;

    Asset removeAsset(String id, String assetId);

    void removeAssets(Assessment assessment);
}
