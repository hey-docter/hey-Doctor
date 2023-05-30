package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.dao.FileDAO;
import com.heydoctor.app.dao.QnaDAO;
import com.heydoctor.app.dao.ReplyDAO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QnaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QnaPageServiceImpl implements QnaPageService{
    private final QnaDAO qnaDAO;
    private final FileDAO fileDAO;
    private final ReplyDAO replyDAO;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(QnaVO qnaVO) {
        qnaDAO.register(qnaVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<QnaDTO> getList(Pagination pagination, Search search) {
        //        게시글 전체 목록
        pagination.getPage();
        final List<QnaDTO> qnas = qnaDAO.getAll(pagination, search);
//        게시글 하나씩 첨부파일 목록 담기
//        qnas.forEach(qna -> qna.setFiles(qnaDAO.getAll(qna.getQnaId())));
        return qnas;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<QnaDTO> read(Long qnaId) {
        return qnaDAO.findById(qnaId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteQna(List<Long> qnaId) {
        qnaId.forEach(qna -> {
//            fileDAO.deleteAll(qna);
//            replyDAO.deleteAll(qna);
            qnaDAO.deleteQna(qna);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotal(Search search) {
        return qnaDAO.findCountOfPost(search);
    }
}
